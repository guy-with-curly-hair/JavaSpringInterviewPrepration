package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.Random;

public class DiceRollingService {


    public static int rollDice()
    {
        return new Random().nextInt(6)+1;
    }
}
