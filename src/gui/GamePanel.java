package gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 11/2/2016.
 */
public class GamePanel extends JPanel {
    private Map<Integer, GUIComponent> actors;
    private final List<GUIComponent> ways;
    private final List<GUIComponent> targetsDestinations;
    private List<GUIComponent> heroesSources;

    public GamePanel(Map<Integer, GUIComponent> actors, List<GUIComponent> ways, List<GUIComponent> targetsDestinations, List<GUIComponent> heroesSources) {
        this.actors = actors;
        this.ways = ways;
        this.targetsDestinations = targetsDestinations;
        this.heroesSources = heroesSources;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawRoads(g2d);
        drawHeroesSources(g2d);
        drawTargetsDestinations(g2d);
        dawActors(g2d);
    }

    private void drawHeroesSources(Graphics2D g2d) {
        for (GUIComponent heroesSource : heroesSources) {
            heroesSource.draw(g2d);
        }
    }

    private void drawTargetsDestinations(Graphics2D g2d) {
        for (GUIComponent targetDestination : targetsDestinations) {
            targetDestination.draw(g2d);
        }
    }

    private void drawRoads(Graphics2D g2d) {
        for (GUIComponent trajectory : ways) {
            trajectory.draw(g2d);
        }
    }

    private void dawActors(Graphics2D g2d) {
        for (GUIComponent actor : actors.values()) {
            actor.draw(g2d);
        }
    }

    public void removeActors(List<Integer> removedActors) {
        for (Integer removedId : removedActors) {
            actors.remove(removedId);
        }
    }
}
