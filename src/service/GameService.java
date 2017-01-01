package service;

import java.util.List;

/**
 * Created by Sidi on 11/3/2016.
 */
public interface GameService {
    void moveActors();

    boolean gameEnded();

    List<Integer> removeActors();
}
