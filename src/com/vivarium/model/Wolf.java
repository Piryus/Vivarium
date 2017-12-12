
package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Wolf extends Carnivore {

    private ArrayList<AreaType> suitableAreas = new ArrayList<>();
    private AreaType currentArea;

    public Wolf(int posX,int posY,float health, float hunger, float vitality, Sex type)
    {

        super(posX,posY,health,hunger,vitality,0.05f,type, null);
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
        this.move(dt*getSpeed(),dt*getSpeed());
        if (this.getPos().getY()>1000){
            this.getPos().setX(0);
            this.getPos().setY(0);
        }
    }

}