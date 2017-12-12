
package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Wolf extends Carnivore {

    private ArrayList<AreaType> suitableAreas = new ArrayList<>();
    private AreaType currentArea;

    public Wolf(int posX,int posY,Vivarium v, float health, float hunger, float vitality, Sex type)
    {

        super(posX,posY,v,health,hunger,vitality,0.05f,type, null);
        suitableAreas.add(AreaType.Plain);
        suitableAreas.add(AreaType.Mountain);
        currentArea = AreaType.Plain;
    }

    @Override
    void setArea(AreaType a)
    {
        this.currentArea = a;
    }


    private int coefX = 1, coefY = 1; // pour debug

    @Override
    public void evoluate(long dt) {
        this.move(dt*getSpeed()*coefX,dt*getSpeed()*coefY);

        if (this.getPos().getX()+50> vivarium.getTerrain().getWidth() ){
            coefX = -1;
        }
        else if (this.getPos().getX() <0){
            coefX = 1;
        }
        if (this.getPos().getY()+50> vivarium.getTerrain().getHeight() ){
            coefY = -1;
        }
        else if (this.getPos().getY()<0){
            coefY = 1;
        }
    }

}