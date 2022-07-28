package CodingQuestions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Function;

public class CyclicBarrieerDemo {



    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier c = new CyclicBarrier(3 , () -> System.out.println(" CyclicBarrier is broken"));

        Function<CyclicBarrier, Runnable>  f1 = (cb) -> (Runnable) () ->
        {
            try {
                System.out.println(" going for wait inside Thread " + Thread.currentThread().getName());
                Thread.sleep(100);
                cb.await();
                System.out.println(" first  wait is over Thread " + Thread.currentThread().getName());
                Thread.sleep(100);
                cb.await();
                System.out.println(" All  wait is over Thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Function<CyclicBarrier, Runnable>  f2 = (cb) -> (Runnable) () ->
        {
            try {
                System.out.println(" going for wait inside Thread " + Thread.currentThread().getName());
                //Thread.sleep(100);
                while (!Thread.currentThread().isInterrupted())
                {
                    System.out.println("not interuppted");
                }
                cb.await();
                System.out.println(" first  wait is over Thread " + Thread.currentThread().getName());
                Thread.sleep(100);
                cb.await();
                System.out.println(" All  wait is over Thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(f1.apply(c),"thread1");
        Thread t2 = new Thread(f1.apply(c),"thread2");
        Thread t3 = new Thread(f2.apply(c),"thread3");


        t1.start();
        t2.start();
        //broken barrier exception
        t3.start();
        Thread.sleep(100);
        t3.interrupt();
    }
}
