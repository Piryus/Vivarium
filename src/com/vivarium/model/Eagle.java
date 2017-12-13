package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Eagle extends Carnivore {
    public Eagle(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed,Sex type) {

        super(posX, posY, v, health, hunger, vitality, speed, type, null, null);
        this.currArea = AreaType.Mountain;
    }

    public boolean isHungry()
    {
        return getHunger()>=5;
    }

    public void lookForFood()
    {

    }

    public void lookForMate(){}

    @Override
    public void evoluate(long dt)
    {
        if(isHungry())
        {
            lookForFood();
        }
        else
        {
            lookForMate();
        }
    }

}