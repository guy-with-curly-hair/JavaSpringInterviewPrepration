package CodingQuestions;

import java.util.function.Consumer;

public class EvenOddWriter1 {
    static Object o1 = new Object();
    static int targetNum=45;

    static volatile int[] a = new int[1];
    public static void main(String[] args)
    {
        a[0]=0;
        Runnable odd = () -> {
            while (a[0] < targetNum) {
                synchronized (o1) {
                    while (a[0] %2 ==1)
                    {
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    a[0]=a[0]+1;
                    System.out.println(" Odd " + a[0]);
                    o1.notifyAll();
                }
            }
        };

        Runnable even = () -> {
            while (a[0] < targetNum) {
                synchronized (o1) {
                    while (a[0] %2==0)
                    {
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    a[0]=a[0]+1;
                    System.out.println(" even " + a[0]);
                    o1.notifyAll();
                }
                }
        };

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);
        t1.start();
        t2.start();

    }
}
//input targetnumber
//thread 1 --evenwriter
//thread2 oddwriter

//how to run 1 by 1 in order
//thread1
//run ()
// thread1 write threa2 wait
// thread1 finish/sout notify() boolean flag; thread2 active...

//thread1running  ( thread1running )--lock
