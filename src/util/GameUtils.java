package util;

import model.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sidi on 11/8/2016.
 */
public class GameUtils {
    private GameUtils() {
    }

    public static <T> Map<Integer, T> assignIdsToActors(List<T> heroes, List<T> targets) {

        Map<Integer, T> assignedActors = new HashMap<>();
        int id = 1;
        for (T hero : heroes) {
            assignedActors.put(id, hero);
            id++;
        }
        for (T target : targets) {
            assignedActors.put(id, target);
            id++;
        }
        return assignedActors;
    }

    public static <T> Map<Integer, T> assignIdsStartingFromIndex(List<T> actors, int startingIndex) {
        Map<Integer, T> assignedActors = new HashMap<>();
        for (T hero : actors) {
            assignedActors.put(startingIndex, hero);
            startingIndex++;
        }
        return assignedActors;
    }

    public static boolean isDifferenceLessThanDelta(Position position1, Position position2, double delta) {
        delta = Math.abs(delta);
        double horizontalDiff = Math.abs(position1.getH() - position2.getH());
        double verticalDiff = Math.abs(position1.getV() - position2.getV());
        return horizontalDiff <= delta && verticalDiff <= delta;
    }
}