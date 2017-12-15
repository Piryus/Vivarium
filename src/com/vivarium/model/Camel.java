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

    public boolean isHungry()
    {
        return getHunger()>=5;
    }

    public void lookForFood()
    {
        Organism o =null;
        //o=scan(this,v);

    }

    public void lookForMate(){}




    public void evoluate(long dt)
    {
        if (isDanger(100)){


        return;
        }
        if(this.isHungry())
        {
            this.lookForFood();
        }
        else
        {
            this.lookForMate();
        }
    }



}
