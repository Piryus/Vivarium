
package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Wolf extends Carnivore {

    private ArrayList<AreaType> suitableAreas;
    private AreaType currentArea;
    public Wolf(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type)
    {

        super(posX,posY,health,hunger,vitality,speed,type);
        suitableAreas.add(AreaType.Plain);
        suitableAreas.add(AreaType.Mountain);
        currentArea = AreaType.Plain;
    }

    @Override
    void setArea(AreaType a)
    {
        this.currentArea = a;
    }



    @Override
    public void evoluate(long dt) {

    }

}