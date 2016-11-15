package model;

/**
 * Created by HP on 10/30/2016.
 */
public enum Direction {
    FORWARD(1),
    BACKWARD(-1);

    final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
