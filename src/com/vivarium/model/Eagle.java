package com.vivarium.model;

/**
 * 
 */
public class Eagle extends Carnivore {

    private AreaType area;
    public Eagle(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type,AreaType a)
    {
        super(posX,posY,health,hunger,vitality,speed,type);
        this.area = a;
    }

    @Override
    void setArea(AreaType a) {
        this.area=a;
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