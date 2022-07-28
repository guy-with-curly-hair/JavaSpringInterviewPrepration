package CodingQuestions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;

import static java.time.LocalTime.now;

public class ProducerConsumerProblem<pubic> {
    public static volatile List<Integer> shared = new ArrayList<>();
    public static volatile boolean intrupt= false;

    public static BiFunction<List<Integer>,Integer, Runnable> producer = (queue,size) -> (Runnable) () -> {
        int i =0;
       while ( !intrupt) {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           synchronized (queue) {
           while (queue.size() == size) {
               //synchronized (queue) {
                    try {
                        System.out.println(" waiting since queue is full"+ " thread bumber " + Thread.currentThread().getName());
                        queue.wait();
                        System.out.println(" got the Waiting over"+ " thread bumber " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            //}
            //synchronized (queue) {
                System.out.println(" putting value in queue " + i+ " thread name " + Thread.currentThread().getName());
                queue.add(i);
                i++;
                queue.notifyAll();
            }
        }
    };

    public static BiFunction<List<Integer>,Integer, Runnable> consumer = (queue,size) -> (Runnable) () -> {

        while(!intrupt) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println(" waiting since queue is empty");
                        queue.wait();
                        System.out.println(" waiting over since  queue is NOT EMPTY");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            //}
            //synchronized (queue) {
                int remove = queue.remove(0);
                System.out.println(" getting/removing value from queue " + remove);
                queue.notifyAll();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        int size = 5;
        Thread prod = new Thread( producer.apply(shared, size));
        Thread prod1 = new Thread( producer.apply(shared, size));
        Thread cons = new Thread( consumer.apply(shared, size));
        prod.start();
        prod1.start();
        Thread.sleep(10000);
        cons.start();
        Instant t1 = Instant.now();
        Thread.sleep(10000);
        Instant t2 = Instant.now();
        Duration time = Duration.between(t1,t2);
        System.out.println( " time " + time.getSeconds());

        intrupt=true;
    }
}
