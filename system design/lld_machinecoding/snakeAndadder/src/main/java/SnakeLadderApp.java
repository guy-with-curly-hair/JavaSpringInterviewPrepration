package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.concurrent.*;

public class SnakeLadderApp {

    boolean isStopped = false;
    BlockingQueue<SnakeLadderGame> queue = new LinkedBlockingQueue<>();

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    public void start() throws InterruptedException {
        while(!isStopped)
        {
            Thread.sleep(10000);
            System.out.println(" service is running");
        }
    }
    public  Future addgame(SnakeLadderGame game)
    {
        return pool.submit(game);
    }
}
