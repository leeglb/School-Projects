package src.game;


import src.game.core.*;
import src.game.utility.Logger;
import src.game.core.SpaceObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the game information and state. Stores and manipulates the game state.
 */
public class GameModel {
    public static final int GAME_HEIGHT = 20;
    public static final int GAME_WIDTH = 10;
    public static final int START_SPAWN_RATE = 2; // spawn rate (percentage chance per tick)
    public static final int SPAWN_RATE_INCREASE = 5; // Increase spawn rate by 5% per level
    public static final int START_LEVEL = 1; // Starting level value
    public static final int SCORE_THRESHOLD = 100; // Score threshold for leveling
    public static final int ASTEROID_DAMAGE = 10; // The amount of damage an asteroid deals
    public static final int ENEMY_DAMAGE = 20; // The amount of damage an enemy deals
    public static final double ENEMY_SPAWN_RATE = 0.5; // Percentage of asteroid spawn chance
    public static final double POWER_UP_SPAWN_RATE = 0.25; // Percentage of asteroid spawn chance

    private final Random random = new Random(); // ONLY USED IN this.spawnObjects()
    private List<SpaceObject> spaceObjectList;

    /**
     * Models a game, storing and modifying data relevant to the game.
     * Logger argument should be a method reference to a .log method such as the UI.log method.
     * Example: Model gameModel = new GameModel(ui::log)
     * - Instantiates an empty list for storing all SpaceObjects the model needs to track.
     * - Instantiates the game level with the starting level value.
     * - Instantiates the game spawn rate with the starting spawn rate.
     * - Instantiates a new ship.
     * - Stores reference to the given logger.
     *
     * @param logger a functional interface for passing information between classes.
     */
    public GameModel(Logger logger) {
        this.spaceObjectList = new ArrayList<>();

    }


    //public ship GetShip() {};

    public List<SpaceObject> getSpaceObjects() {
        return this.spaceObjectList;
    }

    //public int getLevel() {};

    public void addObject(SpaceObject object) {
        if (object != null) { //only runs if our object exists
            getSpaceObjects().add(object); //adding to arrayList in getSpaceObjects
        }
    }

    public void updateGame(int tick) {
        getSpaceObjects().forEach(space -> {
            space.tick(tick);
        }); //for each element, they are moved by tick value.

        getSpaceObjects().forEach(space -> {
            if(space.getY() >  GAME_HEIGHT) {
                getSpaceObjects().remove(space);
            }
            //removes the object if y co-ord is > game height
        });


    }

    public void checkCollisions() {
        //for each object, we check if the co-ords are same as the next one.
        //double for loop
        for(int i = 0; i < getSpaceObjects().size(); i++) {
            for(int j = 1; j < getSpaceObjects().size(); j++) {
                if(getSpaceObjects().get(i).getX() ==  getSpaceObjects().get(j).getX()) {
                    getSpaceObjects().remove(getSpaceObjects().get(i));
                    getSpaceObjects().remove(getSpaceObjects().get(j));
                }
            }
        }
        //to check for the bullet
      

    }

    /**
     * Sets the seed of the Random instance created in the constructor using .setSeed().
     * <p>
     * This method should NEVER be called.
     *
     * @param seed to be set for the Random instance
     * @provided
     */
    public void setRandomSeed(int seed) {
        this.random.setSeed(seed);
    }

}
    
    
