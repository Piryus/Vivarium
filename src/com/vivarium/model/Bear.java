package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Bear extends Carnivore {


    public Bear(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type, ArrayList<AreaType> availableArea)
    {

        super(posX,posY,health,hunger,vitality,speed,type,availableArea);
        this.currArea = AreaType.Mountain;
    }

    @Override
    void setArea(AreaType a) {

    }



    @Override
    public void evoluate(long dt) {

    }

}