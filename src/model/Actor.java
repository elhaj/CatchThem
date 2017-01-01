package model;

/**
 * Created by Sidi on 11/2/2016.
 */
public interface Actor {
    boolean isHero();

    Position getPosition();

    void move();

    boolean didReachDestination();

    // Number of pixels the actor translates per refresh
    double getSpeed();
}
