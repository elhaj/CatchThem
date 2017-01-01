package model;

import util.GameUtils;

/**
 * Created by Sidi on 11/28/2016.
 */
public class VerticalTrajectory implements Trajectory {
    private final Position end;
    private final MovingPosition current;
    private final Direction direction;

    public VerticalTrajectory(Position start, Position end, Direction direction) {
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
        current.setV(current.getV() + direction.getValue() * speed);
    }

    @Override
    public Position getCurrentPosition() {
        return current;
    }}
