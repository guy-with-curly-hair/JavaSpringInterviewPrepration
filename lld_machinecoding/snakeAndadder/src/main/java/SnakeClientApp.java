package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SnakeClientApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Snake> snakes = new ArrayList<>();
        snakes.add( new Snake(1,99,7));
        snakes.add( new Snake(1,89,5));
        snakes.add( new Snake(1,34,23));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add( new Ladder(1,88,7));
        ladders.add( new Ladder(1,44,11));
        ladders.add( new Ladder(1,57,19));
        SnakeLadderGame game1 = new SnakeLadderGame(1,100, snakes, ladders,3,"Game1");
        SnakeLadderGame game2 = new SnakeLadderGame(1,100, snakes, ladders,3,"Game2");
        SnakeLadderApp app = new SnakeLadderApp();
        Thread server = new Thread( () -> {
            try {
                app.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        server.start();
        Future<Player> winner1= app.addgame(game1);
        Future<Player> winner2= app.addgame(game2);

        while( !winner1.isDone() || !winner2.isDone()) {
            Thread.sleep(1000);
            System.out.println("waiting " );
        }

        System.out.println();
       /* Callable<Player> c1 = new Callable<Player>() {
            @Override
            public Player call() throws Exception {
                return game1.start();
            }
        };
        Callable<Player> c2 = new Callable<Player>() {
            @Override
            public Player call() throws Exception {
                return game2.start();
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Player> winner1= service.submit(c1);
        Future<Player> winner2= service.submit(c2);
        while( !winner1.isDone() || !winner2.isDone()) {
            Thread.sleep(1000);
            System.out.println("waiting " );
        }
        System.out.println("winner of game 1 " + winner1.get().getId());
        System.out.println("winner of game 2 " + winner2.get().getId());

        service.shutdownNow();*/
    }
}
