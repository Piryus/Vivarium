package com.vivarium.model;

/**
 * 
 */
public class Bouquetin extends Herbivore {

    /**
     * Default constructor
     */
    public Bouquetin(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed, Sex type) { // TODO
        super(posX, posY, v,health,hunger,vitality,speed,type, null, null);
    }

    @Override
    public void evoluate(long dt) {

    }

}