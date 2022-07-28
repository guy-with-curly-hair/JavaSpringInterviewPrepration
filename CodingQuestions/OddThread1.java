package CodingQuestions;

class OddThread1 extends Thread {

    OddThread1 depondsOn;
    Object o1;
    int targetNum;
    int[]a = new int[1];
    String name;
    int step;

    boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setDepondsOn(OddThread1 depondsOn) {
        this.depondsOn = depondsOn;
    }

    public OddThread1(Object o1, int targetNum, int a, boolean flag, String name, int step) {
        this.o1 = o1;
        this.targetNum = targetNum;
        this.a[0] = a;
        this.flag = flag;
        this.name = name;
        this.step = step;
    }


    @Override
    public void run() {
            synchronized (o1) {
                while(!flag) {
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (a[0] < targetNum) {
                    System.out.println("Count " + a[0]);
                a[0]=a[0]+3;
                this.flag=false;
                depondsOn.setFlag(true);
            }
                o1.notifyAll();
        }
    }
}