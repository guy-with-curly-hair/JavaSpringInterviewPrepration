package lld_machinecoding.snakeAndadder.src.main.java;

public class Snake {

    int id;
    int head;
    int tail;

    public Snake(int id, int head, int tail) {
        this.id = id;
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
