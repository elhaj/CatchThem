package model;

/**
 * Created by HP on 11/2/2016.
 */
public class CircleActor implements Actor {

    private final boolean isHero;
    private final Trajectory trajectory;
    private final int radius;
    private double speed;

    public CircleActor(boolean isHero, Trajectory trajectory, int radius, double speed) {
        this.isHero = isHero;
        this.trajectory = trajectory;
        this.radius = radius;
        this.speed = speed;
    }

    @Override
    public boolean isHero() {
        return isHero;
    }

    @Override
    public Position getPosition() {
        return trajectory.getCurrentPosition();
    }

    @Override
    public void move() {
        trajectory.moveToNextPosition(speed);
    }

    @Override
    public boolean didReachDestination() {
        return trajectory.isEndReached();
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    public int getRadius() {
        return radius;
    }
}
