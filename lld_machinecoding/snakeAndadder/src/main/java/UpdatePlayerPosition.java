package lld_machinecoding.snakeAndadder.src.main.java;

import java.util.List;
import java.util.Optional;

public class UpdatePlayerPosition {

    private SnakeBiteService snakeBiteService;
    private LadderService ladderService;
    private ValdiationService valdiationService;

    public UpdatePlayerPosition(SnakeBiteService snakeBiteService, LadderService ladderService, ValdiationService valdiationService) {
        this.snakeBiteService = snakeBiteService;
        this.ladderService = ladderService;
        this.valdiationService = valdiationService;
    }

    public  int update(Player p , int diceCount)
    {
        int currPosition = p.getCurrPosition();
        currPosition = snakeBiteService.checkSnakeBite(currPosition + diceCount);
        currPosition =ladderService.checkLadderAvailable(currPosition);
        updatePlayerLocation(p, currPosition);
        return currPosition;
    }

    private  void updatePlayerLocation(Player p ,int currPosition) {
        //validation
        if(valdiationService.validMove(currPosition))
        p.setCurrPosition(currPosition);
    }


}
