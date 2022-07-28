package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.List;
import java.util.Optional;

class LadderService {
         List<Ladder> ladders;
    public LadderService(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public int checkLadderAvailable(int position)
        {
            Optional<Ladder> op = ladders.stream().filter(i -> i.getTail() == position).findFirst();
            if(op.isPresent())
                System.out.println("UDDD liyaaaa m " + position + " is jgh par "+ " ab m ja rha hun " + op.get().getHead());
            return op.isEmpty() ? position : op.get().getTail();
        }
    }