package service;

import java.util.List;

/**
 * Created by HP on 11/3/2016.
 */
public interface GameService {
    void moveActors();

    boolean gameEnded();

    List<Integer> removeActors();
}
