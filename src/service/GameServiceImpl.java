package service;

import model.Actor;
import util.GameUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sidi on 11/3/2016.
 */
public class GameServiceImpl implements GameService {

    private static final int TOUCHING_DELTA = 20;
    private Map<Integer, Actor> heroesMap = new HashMap<>();
    private Map<Integer, Actor> targetsMap = new HashMap<>();

    public GameServiceImpl(Map<Integer, Actor> heroesMap, Map<Integer, Actor> targetsMap) {
        this.heroesMap = heroesMap;
        this.targetsMap = targetsMap;
    }

    @Override
    public void moveActors() {
        moveActors(heroesMap);
        moveActors(targetsMap);
    }

    private void moveActors(Map<Integer, Actor> actorsMap) {
        actorsMap.values().stream().filter(actor -> !actor.didReachDestination()).forEach(Actor::move);
    }

    @Override
    public boolean gameEnded() {
        return targetsMap.isEmpty();
    }

    @Override
    public List<Integer> removeActors() {
        List<Integer> allRemovedActors = new ArrayList<>();
        allRemovedActors.addAll(removeActorsWhoReachedDestination(heroesMap));
        allRemovedActors.addAll(removeActorsWhoReachedDestination(targetsMap));
        allRemovedActors.addAll(removeActorsWhoTouchedEachOther());
        return allRemovedActors;
    }

    private List<Integer> removeActorsWhoTouchedEachOther() {
        List<Integer> actorsWhoTouchedEachOther = new ArrayList<>();
        for (Map.Entry<Integer, Actor> heroEntry : heroesMap.entrySet()) {
            targetsMap.entrySet().stream().filter(targetEntry -> GameUtils.isDifferenceLessThanDelta(heroEntry.getValue().getPosition(), targetEntry.getValue().getPosition(), TOUCHING_DELTA)).forEach(targetEntry -> {
                actorsWhoTouchedEachOther.add(heroEntry.getKey());
                actorsWhoTouchedEachOther.add(targetEntry.getKey());
            });
        }
        for (Integer heroId : actorsWhoTouchedEachOther) heroesMap.remove(heroId);
        for (Integer targetId : actorsWhoTouchedEachOther) targetsMap.remove(targetId);
        return actorsWhoTouchedEachOther;
    }

    private List<Integer> removeActorsWhoReachedDestination(Map<Integer, Actor> actors) {
        List<Integer> actorsWhoReachedDestination = actors.entrySet().stream().filter(heroesEntry -> heroesEntry.getValue().didReachDestination()).map(Map.Entry::getKey).collect(Collectors.toList());
        actorsWhoReachedDestination.forEach(actors::remove);
        return actorsWhoReachedDestination;
    }
}