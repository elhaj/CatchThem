import controller.GameController;
import controller.GameControllerBuilder;
import gui.CircleGUIComponent;
import gui.GUIComponent;
import gui.GameFrame;
import gui.ImageBasedGuiComponent;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static model.Direction.BACKWARD;
import static model.Direction.FORWARD;

/**
 * Created by HP on 11/2/2016.
 */
public class Main {
    private static final int ACTOR_RADIUS = 20;

    private static final String HORIZONTAL_WAY_IMAGE = "images/road.jpg";
    private static final String LEFT_TARGET_DEST = "images/left-cave.png";
    private static final String RIGHT_TARGET_DEST = "images/right-cave.png";
    private static final String LEFT_HERO_SOURCE = "images/left-bank.png";
    private static final String RIGHT_HERO_SOURCE = "images/right-bank.png";

    private static final Image horizontalWayImage;
    private static final Image leftTargetDestinationImage;
    private static final Image rightTargetDestinationImage;
    private static final Image leftHeroSourceImage;
    private static final Image rightHeroSourceImage;

    static {
        horizontalWayImage = buildImage(HORIZONTAL_WAY_IMAGE);
        leftTargetDestinationImage = buildImage(LEFT_TARGET_DEST);
        rightTargetDestinationImage = buildImage(RIGHT_TARGET_DEST);
        leftHeroSourceImage = buildImage(LEFT_HERO_SOURCE);
        rightHeroSourceImage = buildImage(RIGHT_HERO_SOURCE);
    }

    private static Image buildImage(String imagePath) {
        URL resource = Main.class.getResource(imagePath);
        return new ImageIcon(resource).getImage();
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        List<GUIComponent> ways = buildWays(gameFrame);
        List<Actor> heroes = buildHeroes();
        List<Actor> targets = buildTargets();
        List<GUIComponent> guiHeroes = buildGuiHeroes(heroes);
        List<GUIComponent> guiTargets = buildGuiTargetsList(targets);
        List<GUIComponent> targetsDestinations = buildGuiTargetsDestinations(gameFrame);
        List<GUIComponent> heroesPlaces = buildGuiHeroesPlaces(gameFrame);

        GameController controller = new GameControllerBuilder()
                .withHeroes(heroes)
                .withTargets(targets)
                .withGuiHeroes(guiHeroes)
                .withGuiTargets(guiTargets)
                .withGuiWays(ways)
                .withLosingMessage("Game Over")
                .withGameFrame(gameFrame)
                .withTargetsDestinations(targetsDestinations)
                .withGuiHeroesPlaces(heroesPlaces)
                .build();
        controller.startGame();
    }

    private static List<GUIComponent> buildGuiHeroesPlaces(ImageObserver imageObserver) {
        List<GUIComponent> heroesPlaces = new ArrayList<>();
        heroesPlaces.add(new ImageBasedGuiComponent(new PositionImpl(10, 62), 90, 80, imageObserver, rightHeroSourceImage));
        heroesPlaces.add(new ImageBasedGuiComponent(new PositionImpl(595, 262), 90, 80, imageObserver, leftHeroSourceImage));
        return heroesPlaces;
    }

    private static List<GUIComponent> buildGuiTargetsDestinations(ImageObserver imageObserver) {
        List<GUIComponent> targetsDestination = new ArrayList<>();
        targetsDestination.add(new ImageBasedGuiComponent(new PositionImpl(595, 62), 90, 80, imageObserver, leftTargetDestinationImage));
        targetsDestination.add(new ImageBasedGuiComponent(new PositionImpl(10, 262), 90, 80, imageObserver, rightTargetDestinationImage));
        return targetsDestination;
    }

    private static ArrayList<GUIComponent> buildWays(ImageObserver imageObserver) {
        ArrayList<GUIComponent> result = new ArrayList<>();
        result.add(new ImageBasedGuiComponent(new PositionImpl(100, 100), 500, 30, imageObserver, horizontalWayImage));
        result.add(new ImageBasedGuiComponent(new PositionImpl(100, 300), 500, 30, imageObserver, horizontalWayImage));
        return result;
    }

    private static List<Actor> buildHeroes() {
        List<Actor> heroes = new ArrayList<>();
        addActor(heroes, ACTOR_RADIUS, true, new HorizontalLineTrajectory(new PositionImpl(100, 100), new PositionImpl(600, 100), FORWARD), 1.15);
        addActor(heroes, ACTOR_RADIUS, true, new HorizontalLineTrajectory(new PositionImpl(550, 300), new PositionImpl(100, 300), BACKWARD), 1);
        return heroes;
    }

    private static List<Actor> buildTargets() {
        List<Actor> targets = new ArrayList<>();
        addActor(targets, ACTOR_RADIUS, false, new HorizontalLineTrajectory(new PositionImpl(170, 100), new PositionImpl(600, 100), FORWARD), 1);
        addActor(targets, ACTOR_RADIUS, false, new HorizontalLineTrajectory(new PositionImpl(400, 300), new PositionImpl(100, 300), BACKWARD), 1);
        return targets;
    }

    private static void addActor(List<Actor> actors, int radius, boolean isAHero, Trajectory trajectory, double speed) {
        actors.add(new CircleActor(isAHero, trajectory, radius, speed));
    }

    private static List<GUIComponent> buildGuiHeroes(List<Actor> heroes) {
        return heroes.stream().map(hero -> new CircleGUIComponent((CircleActor) hero)).collect(Collectors.toList());
    }

    private static List<GUIComponent> buildGuiTargetsList(List<Actor> targets) {
        return targets.stream().map(target -> new CircleGUIComponent((CircleActor) target)).collect(Collectors.toList());
    }
}
