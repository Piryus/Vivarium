package com.vivarium.model;

/**
 * 
 */
public abstract class Herbivore extends Animal {

    /**
     * Default constructor
     */
    public Herbivore(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed, Sex type) {
        super( posX, posY, v, health,  hunger,  vitality, speed, type, null);
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