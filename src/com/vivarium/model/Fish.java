package com.vivarium.model;

/**
 * 
 */
public abstract class Fish extends Herbivore {

    /**
     * Default constructor
     */
    public Fish(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type) {
        super(posX,posY, health, hunger, vitality,speed,type);
    }

    @Override
    void setArea(AreaType a) {

    }



}