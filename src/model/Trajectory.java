package model;

/**
 * Created by HP on 10/30/2016.
 */
public interface Trajectory {
    boolean isEndReached();

    void moveToNextPosition(double speed);

    Position getCurrentPosition();
}
