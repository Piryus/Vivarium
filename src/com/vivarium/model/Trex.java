package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Trex extends Carnivore {

    public Trex(int posX,int posY,Vivarium v, float health, float hunger, float vitality,float speed, Sex type, ArrayList<AreaType> availableArea)
    {

        super(posX,posY,v,health,hunger,vitality,speed,type,availableArea);
        this.currArea = AreaType.Mountain;
    }

    @Override
    void setArea(AreaType a) {

    }


    @Override
    public void evoluate(long dt) {

    }

}