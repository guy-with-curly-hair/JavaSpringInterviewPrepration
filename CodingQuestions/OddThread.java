package CodingQuestions;

class OddThread extends Thread {

    OddThread depondsOn;
    Object o1;
    int targetNum;
    int[]a = new int[1];
    String name;
    int step;

    boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setDepondsOn(OddThread depondsOn) {
        this.depondsOn = depondsOn;
    }

    public OddThread( Object o1, int targetNum, int a, boolean flag,String name,int step) {
        this.o1 = o1;
        this.targetNum = targetNum;
        this.a[0] = a;
        this.flag = flag;
        this.name = name;
        this.step = step;
    }


    @Override
    public void run() {
        while (a[0] < targetNum) {
            synchronized (o1) {
                while(!flag) {
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Count " + a[0]);
                a[0]=a[0]+3;
                this.flag=false;
                depondsOn.setFlag(true);
                o1.notifyAll();
            }


        }
    }
}