package CodingQuestions;

import java.util.function.Consumer;

public class EvenOddWriter {

    static volatile boolean evenTChance =false;
    static volatile boolean oddThreadChance =true;
    static Object o1 = new Object();
    static int targetNum=45;
    static int steps=10; //constructu

    static volatile int[] a = new int[1];
    public static void main(String[] args)
    {
    Consumer<OddThread> OFF = t1 -> t1.setFlag(false);
    Consumer<OddThread> ON =  t2 -> t2.setFlag(true);

        Runnable odd = () -> {
            while (a[0] < targetNum) {
                while (evenTChance)
                    continue;

                synchronized (a){
                    a[0]=a[0]+1;
                    System.out.println(" Odd - " + a[0]);
                    evenTChance = true;
                    oddThreadChance = false;
                }
            }
        };

        Runnable even = () -> {
            while (a[0] < targetNum) {
                while (oddThreadChance)
                    continue;

                synchronized (o1) {
                    a[0]=a[0]+1;
                    System.out.println(" Even - " + a[0]);
                    evenTChance = false;
                    oddThreadChance = true;
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
