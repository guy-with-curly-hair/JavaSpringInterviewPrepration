package CodingQuestions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Function;

public class CountDownLatchDemo {



    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(2);

        Function<CountDownLatch, Runnable>  waiter = (cb) -> (Runnable) () ->
        {
            System.out.println(" waiter arrived" + Thread.currentThread().getName());
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" all food arrived lets serve the food " + Thread.currentThread().getName());
        };
        Function<CountDownLatch, Runnable>  foodIndicator = (cb) -> (Runnable) () ->
        {
            try {
                Thread.sleep(1000);
                cb.countDown();
                System.out.println(" first food arrived Thread " + Thread.currentThread().getName());
                Thread.sleep(10000);
                cb.countDown();
                System.out.println(" second food arrived Thread " + Thread.currentThread().getName());
                cb.countDown();//no exception simple it will be only 0
                System.out.println(" cl count" + cb.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(waiter.apply(c),"thread1");
        Thread t2 = new Thread(waiter.apply(c),"thread2");
        Thread t3 = new Thread(waiter.apply(c),"thread3");

        Thread t4 = new Thread(foodIndicator.apply(c),"thread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //c.await();
    }
}
