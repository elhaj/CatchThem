package model;

import java.util.List;

/**
 * Created by Sidi on 11/18/2016.
 */
public class CompositeTrajectory implements Trajectory {
    private final List<Trajectory> trajectories;
    private int currentTrajectoryIndex;

    public CompositeTrajectory(List<Trajectory> trajectories) {
        this.trajectories = trajectories;
        currentTrajectoryIndex = 0;
    }

    @Override
    public boolean isEndReached() {
        return currentTrajectoryIndex == trajectories.size();
    }

    @Override
    public void moveToNextPosition(double speed) {
        Trajectory currentTrajectory = trajectories.get(currentTrajectoryIndex);
        currentTrajectory.moveToNextPosition(speed);
        if (currentTrajectory.isEndReached()) {
            currentTrajectoryIndex++;
        }

    }

    @Override
    public Position getCurrentPosition() {
        return trajectories.get(currentTrajectoryIndex).getCurrentPosition();
    }
}
