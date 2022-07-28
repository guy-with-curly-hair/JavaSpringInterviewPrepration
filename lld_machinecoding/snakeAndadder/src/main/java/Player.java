package lld_machinecoding.snakeAndadder.src.main.java;

public class Player {

    int id;
    String name;
    int currPosition;

    public int getId() {
        return id;
    }

    public Player(int id, String name, int currPosition) {
        this.id = id;
        this.name = name;
        this.currPosition = currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }

    public int getCurrPosition() {
        return currPosition;
    }
}
