package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;


public class SnakeLadderGame implements Callable<Player> {

    int startingPoint;
    int endPoint;
    List<Snake> snakes;
    List<Ladder> ladder;
    Queue<Player> players;
    UpdatePlayerPosition updatePlayerPosition;
    SnakeBiteService snakeBiteService;
    LadderService ladderServicel;
    ValdiationService valdiationService;
    boolean winnerAvailable=false;
    boolean gameInterupted=false;
    String game ;

    public SnakeLadderGame(int startingPoint, int endPoint, List<Snake> snakes, List<Ladder> ladder,int countOfPlayer, String game) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.snakes = snakes;
        this.ladder = ladder;
        this.players = new ArrayDeque<>(countOfPlayer);
        initilizePlayer(countOfPlayer);
        this.snakeBiteService = new SnakeBiteService(snakes);
        this.ladderServicel = new LadderService(ladder);
        this.valdiationService = new ValdiationService(startingPoint,endPoint);
        this.updatePlayerPosition = new UpdatePlayerPosition(this.snakeBiteService, this.ladderServicel,this.valdiationService);
        this.game = game;
    }

    private void initilizePlayer(int countOfPlayer) {
        for ( int i =0 ; i< countOfPlayer;i++)
        {
            Player p = new Player(i+1,String.valueOf(i),0);
            players.add(p);
        }
    }

    public Player start() throws InterruptedException {
        int pos=0;
        Player winner=null;

        System.out.println(" Playing game " + game);
        while ( !gameInterupted && !winnerAvailable)
        {
            Player playerChance = players.poll();
            System.out.println("player " + playerChance.id + " playing " + " is at " + playerChance.getCurrPosition());
            int diceCount = DiceRollingService.rollDice();
            Thread.sleep(100);
            pos = updatePlayerPosition.update(playerChance,diceCount);
            if(isWinner(pos)) {
                winnerAvailable=true;
                winner= playerChance;
            }
            players.add(playerChance);

        }
        System.out.println("Winner for game  " + game + " player " + winner.id);
        return winner;
    }

    private boolean isWinner(int pos) {
       return  pos==endPoint ? true : false;
    }

    @Override
    public Player call() throws Exception {
        return start();
    }
}
