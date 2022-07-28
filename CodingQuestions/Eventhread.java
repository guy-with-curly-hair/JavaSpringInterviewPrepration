package CodingQuestions;

class Eventhread extends Thread{
    boolean t1Chance;
    boolean t2Chance;
    Object o1;
    int targetNum;
    int i =0;


    public Eventhread(boolean t1Chance, boolean t2Chance, Object o1) {
        this.t1Chance = t1Chance;
        this.t2Chance = t2Chance;
        this.o1 = o1;
    }

    @Override
    public void run() {
        while (i < targetNum) {
            try {
                writeEven(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {
                System.out.println(" even " + i);
                try {
                    o1.notify();
                    o1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void writeEven(int i) throws InterruptedException {
        synchronized (o1)
        {
            while( i %2 !=0)
            {
                o1.wait();
            }
            System.out.println("Even " + i);
        }
    }
    }