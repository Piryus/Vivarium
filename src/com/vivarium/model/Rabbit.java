package com.vivarium.model;

/**
 * 
 */
public class Rabbit extends Herbivore {

    /**
     * Default constructor
     */
    public Rabbit(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type) {
        super(posX, posY,health,hunger,vitality,speed,type);
    }

    @Override
    void setArea(AreaType a) {

    }



    @Override
    public void evoluate(long dt) {

    }

}