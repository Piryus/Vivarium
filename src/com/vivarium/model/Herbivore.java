package com.vivarium.model;

/**
 * 
 */
public abstract class Herbivore extends Animal {

    /**
     * Default constructor
     */
    public Herbivore(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type) {
        super( posX, posY, health,  hunger,  vitality, speed, type);
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