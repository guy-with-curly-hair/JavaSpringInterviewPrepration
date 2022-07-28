package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.List;
import java.util.Optional;

class SnakeBiteService {
     List<Snake> snakes;
    public SnakeBiteService(List<Snake> snakes) {
        this.snakes = snakes;
    }
    public int checkSnakeBite(int position)
        {
            Optional<Snake> op = snakes.stream().filter(i -> i.getHead() == position).findFirst();
            if(op.isPresent())
                System.out.println("Daas liyaaaa " + position + " is jgh par "+ " ab m ja rha hun " + op.get().getTail());
            System.out.println();
            return op.isEmpty() ? position : op.get().getTail();
        }

    }

