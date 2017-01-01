package controller;

import com.sun.media.jfxmedia.logging.Logger;
import gui.GameFrame;
import gui.GamePanel;
import service.GameService;

import javax.swing.*;
import java.util.List;

/**
 * Created by Sidi on 11/3/2016.
 */
public class GameController {

    private final GamePanel gamePanel;
    private final GameFrame gameFrame;
    private final GameService gameService;
    private final String losingMessage;

    GameController(GamePanel gamePanel, GameFrame gameFrame, GameService gameService, String losingMessage) {
        this.gamePanel = gamePanel;
        this.gameFrame = gameFrame;
        this.gameService = gameService;
        this.losingMessage = losingMessage;
    }

    public void startGame() {
        gameFrame.setVisible(true);
        while (!gameService.gameEnded()) {
            gameService.moveActors();
            List<Integer> removedActors = gameService.removeActors();
            gamePanel.removeActors(removedActors);
            gamePanel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Logger.logMsg(Logger.WARNING, "Unexpected interruption happened");
            }
        }

        JOptionPane.showMessageDialog(gameFrame, losingMessage);
    }
}
