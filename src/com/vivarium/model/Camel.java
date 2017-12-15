package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Camel extends Herbivore { // TODO

    /**
     * Default constructor
     */
    public Camel(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain})));
        currArea = AreaType.Desert;
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
        /*
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
        }*/
    }



}
