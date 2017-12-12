package com.vivarium.model;

/**
 * 
 */
public class Blowfish extends Fish {

    /**
     * Default constructor
     */
    public Blowfish(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed, Sex type) {
        super(posX,posY,v,health,hunger,vitality,speed,type);
    }

    @Override
    public void evoluate(long dt) {

    }

}