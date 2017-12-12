package com.vivarium.model;

/**
 * 
 */
public class FreshwaterFish extends Fish {

    /**
     * Default constructor
     */
    public FreshwaterFish(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type) {
        super(posX,posY,health,hunger,vitality,speed,type);
    }

    @Override
    public void evoluate(long dt) {

    }

}