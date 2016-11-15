package gui;

import model.CircleActor;
import model.Position;

import java.awt.*;

/**
 * Created by HP on 11/2/2016.
 */
public class CircleGUIComponent implements GUIComponent {
    private final CircleActor actor;

    public CircleGUIComponent(CircleActor actor) {
        this.actor = actor;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Position position = actor.getPosition();
        g2d.setColor(actor.isHero() ? Color.BLUE : Color.RED);
        g2d.fillOval((int) position.getH(), (int) position.getV(), actor.getRadius(), actor.getRadius());
    }
}
