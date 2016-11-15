package controller;

import gui.GUIComponent;
import gui.GameFrame;
import gui.GamePanel;
import model.Actor;
import service.GameService;
import service.GameServiceImpl;
import util.GameUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by HP on 11/8/2016.
 */
public class GameControllerBuilder {
    private List<Actor> heroes;
    private List<Actor> targets;
    private List<GUIComponent> guiHeroes;
    private List<GUIComponent> guiTargets;
    private List<GUIComponent> ways;
    private String losingMessage;
    private GameFrame gameFrame;
    private List<GUIComponent> targetsDestinations;
    private List<GUIComponent> heroesPlaces;

    public GameControllerBuilder() {
    }

    public GameControllerBuilder withHeroes(List<Actor> heroes) {
        this.heroes = heroes;
        return this;
    }

    public GameControllerBuilder withTargets(List<Actor> targets) {
        this.targets = targets;
        return this;
    }

    public GameControllerBuilder withGuiHeroes(List<GUIComponent> guiHeroes) {
        this.guiHeroes = guiHeroes;
        return this;
    }

    public GameControllerBuilder withGuiTargets(List<GUIComponent> guiTargets) {
        this.guiTargets = guiTargets;
        return this;
    }

    public GameControllerBuilder withGuiWays(List<GUIComponent> ways) {
        this.ways = ways;
        return this;
    }

    public GameControllerBuilder withLosingMessage(String losingMessage) {
        this.losingMessage = losingMessage;
        return this;
    }

    public GameControllerBuilder withGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        return this;
    }

    public GameControllerBuilder withTargetsDestinations(List<GUIComponent> targetsDestinations) {
        this.targetsDestinations = targetsDestinations;
        return this;
    }

    public GameControllerBuilder withGuiHeroesPlaces(List<GUIComponent> heroesPlaces) {
        this.heroesPlaces = heroesPlaces;
        return this;
    }

    public GameController build() {
        Map<Integer, GUIComponent> guiActorsWithIds = GameUtils.assignIdsToActors(guiHeroes, guiTargets);
        GamePanel gamePanel = new GamePanel(guiActorsWithIds, ways, targetsDestinations, heroesPlaces);
        gameFrame.setGamePanel(gamePanel);
        Map<Integer, Actor> heroesWithIds = GameUtils.assignIdsStartingFromIndex(heroes, 1);
        Map<Integer, Actor> targetsWithIds = GameUtils.assignIdsStartingFromIndex(targets, heroes.size() + 1);
        GameService gameService = new GameServiceImpl(heroesWithIds, targetsWithIds);
        return new GameController(gamePanel, gameFrame, gameService, losingMessage);
    }
}
