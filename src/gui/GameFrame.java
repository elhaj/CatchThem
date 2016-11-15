package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HP on 11/2/2016.
 */
public class GameFrame extends JFrame {

    private static final String TITLE = "Fun News";
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    public GameFrame() throws HeadlessException {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        moveToCenter();
        setResizable(false);
    }

    private void moveToCenter() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - getSize().width / 2, dimension.height / 2 - getSize().height / 2);
    }

    public void setGamePanel(GamePanel gamePanel) {
        getContentPane().add(gamePanel);
    }
}
