package CodingQuestions;

import java.util.function.BiFunction;

public class deadlock {
    public static void main(String[] args)
    {
    Object o3 = new Object();
    Object o4 = new Object();
    //Approach 1 using creating myRunnable class
 ///myRunnable m1 = new myRunnable(o1,o2);

        //Approach 2 use Java8 features to create lamdas to implement runnable
    BiFunction<Object,Object,Runnable> b1 = (o1,o2) -> (Runnable) () -> {
        synchronized (o1)
        {
            System.out.println(" Inside lock " + o1 + "  thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2)
            {
                System.out.println("bot lock taken");
            }
        }
    };
//myRunnable m2 = new myRunnable(o2,o1);

Thread t1 = new Thread(b1.apply(o3,o4));
Thread t2 = new Thread(b1.apply(o4,o3));
        t1.start();
        t2.start();

    }


}
 class myRunnable implements Runnable
{

    Object lock1;
    Object lock2;

    public myRunnable(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1)
        {
            System.out.println(" Inside lock " + lock1 + "  thread " + Thread.currentThread().getName());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2)
            {
                System.out.println("both lock taken ");
            }
        }


    }
}


//Employee class

//e1 ( this )

//e2 ( random)
//e3  ( this )
//e4 ( class.class) //static sync


//t1 -> o1  -> e1   unblocked ( run )
//t2 -> o1 ->e2     unbloced( run )
//t3 -> o1 -> e3    blocked ( waiting)
// t4 -> o1 -> e4   RUNNING

//t5 --> o2 -> e3      RUNNING( since this/lock is different in diffent objects
//t6 -> o2 --> e4      BLOCKED


