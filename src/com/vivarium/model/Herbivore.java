package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public abstract class Herbivore extends Animal {

    /**
     * Default constructor
     */
    public Herbivore(int posX, int posY, Vivarium v, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> avArea, ArrayList<AreaType> dfArea) {
        super( posX, posY, v, health,  hunger,  vitality, speed, type, avArea, dfArea);
    }

    /**
     * @param a 
     * @return
     */
    public Boolean eat(Vegetal a) {
            if (a.getEdible()){
                a.setEdible(false);
                this.setHunger(0);
                return true;

            }
        return false;
    }

}