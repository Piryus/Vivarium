package com.vivarium.model;

/**
 * 
 */
public class Camel extends Herbivore { // TODO

    /**
     * Default constructor
     */
    public Camel(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed, Sex type) {
        super(posX,posY,v,health,hunger,vitality,speed,type, null, null);
    }

    @Override
    public void evoluate(long dt) {

    }

}