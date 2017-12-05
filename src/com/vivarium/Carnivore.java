package com.vivarium;
import java.util.*;

/**
 * 
 */
public abstract class Carnivore extends Animal {

    /**
     * Default constructor
     */
    public Carnivore() {
    }

    /**
     * @param a 
     * @return
     */
    public Boolean eat(Herbivore a) {
        // TODO implement here
        return true;
    }

}