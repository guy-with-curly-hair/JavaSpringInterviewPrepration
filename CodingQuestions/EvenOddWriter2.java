package CodingQuestions;

public class EvenOddWriter2 {
    static Object o1 = new Object();
    static int targetNum=45;
    static  int step =3;

    static volatile int[] a = new int[1];
    public static void main(String[] args)
    {

        OddThread t0 = new OddThread(o1,targetNum,1,true,"t0",step);;
        OddThread t1 = new OddThread(o1,targetNum,2,false,"t1",step);
        OddThread  t2 = new OddThread(o1,targetNum,3,false,"t2",step);
        t0.setDepondsOn(t1);
        t1.setDepondsOn(t2);
        t2.setDepondsOn(t0);
        t0.start();
        t1.start();
        t2.start();
    }

}

