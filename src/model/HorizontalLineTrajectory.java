package model;

import util.GameUtils;

/**
 * Created by HP on 10/30/2016.
 */
public class HorizontalLineTrajectory implements Trajectory {
    private static final int POS_EQUAL_DELTA = 4;
    private final Position end;
    private final MovingPosition current;
    private final Direction direction;

    public HorizontalLineTrajectory(Position start, Position end, Direction direction) {
        this.end = end;
        this.current = new MovingPositionImpl(start);
        this.direction = direction;
    }

    @Override
    public boolean isEndReached() {
        return GameUtils.isDifferenceLessThanDelta(current, end, POS_EQUAL_DELTA);
    }

    @Override
    public void moveToNextPosition(double speed) {
        current.setH(current.getH() + direction.getValue() * speed);
    }

    @Override
    public Position getCurrentPosition() {
        return current;
    }
}
