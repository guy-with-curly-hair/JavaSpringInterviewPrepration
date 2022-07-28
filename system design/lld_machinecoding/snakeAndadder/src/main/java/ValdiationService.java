package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ValdiationService {

    int boardStatPoint;
    int boardEndPoint;

    public ValdiationService(int boardStatPoint, int boardEndPoint) {
        this.boardStatPoint = boardStatPoint;
        this.boardEndPoint = boardEndPoint;
    }

    boolean validSnakes(List<Snake> snakes)
    {

        Predicate<Snake> snakeInValid = snake -> (snake.getHead() < snake.getTail() || snake.getHead() > boardEndPoint && snake.getTail() < boardStatPoint);
        Optional<Snake>  op = snakes.stream().filter(snake -> snakeInValid.test(snake)).findAny();
        return op.isPresent() ? false : true;
    }

    boolean validLadder(List<Ladder> ladders)
    {
        Predicate<Ladder> ladderInValid = snake -> (snake.getHead() < snake.getTail() || snake.getHead() > boardEndPoint && snake.getTail() < boardStatPoint);
        Optional<Ladder>  op = ladders.stream().filter(ladder -> ladderInValid.test(ladder)).findAny();
        return op.isPresent() ? false : true;
    }

    boolean validMove( int position) {
        return position > boardEndPoint || position < boardStatPoint ? false : true;
    }
}
