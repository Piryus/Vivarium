package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Eagle extends Carnivore {
    public Eagle(int posX,int posY,float health, float hunger, float vitality,float speed,Sex type, ArrayList<AreaType> availableArea)
    {

        super(posX,posY,health,hunger,vitality,speed,type,availableArea);
        this.currArea = AreaType.Mountain;
    }

    @Override
    void setArea(AreaType a)
    {
        this.currArea=a;
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