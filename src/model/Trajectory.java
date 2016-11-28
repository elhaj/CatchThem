package model;

/**
 * Created by HP on 10/30/2016.
 */
public interface Trajectory {
    int POS_EQUAL_DELTA = 4;

    boolean isEndReached();

    void moveToNextPosition(double speed);

    Position getCurrentPosition();
}