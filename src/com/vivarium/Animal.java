package com.vivarium;
import java.util.*;

/**
 * 
 */
public abstract class Animal extends Organism {

    /**
     * Default constructor
     */
    public Animal() {
    }

    /**
     * 
     */
    private float health;

    /**
     * 
     */
    private float hunger;

    /**
     * 
     */
    private float vitality;

    /**
     * 
     */
    private float speed;

    /**
     * 
     */
    private Sex type;



    /**
     * 
     */
    public void Animal() {
        // TODO implement here
    }

    /**
     * @param dt
     */
    public void evoluate(float dt) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getHP() {
        // TODO implement here
        return 0;
    }

}