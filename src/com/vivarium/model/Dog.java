package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Dog extends Carnivore { // TODO
    public Dog(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed, Sex type)
    {

        super(posX,posY,v,health,hunger,vitality,speed, type, null, null);
        this.currArea = AreaType.Plain;
    }


    @Override
    public void evoluate(long dt) {
        super.evoluate(dt);

    }

}