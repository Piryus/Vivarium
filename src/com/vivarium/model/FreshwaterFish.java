package com.vivarium.model;

/**
 * 
 */
public class FreshwaterFish extends Fish {

    /**
     * Default constructor
     */
    public FreshwaterFish(int posX,int posY,Vivarium v, Sex type) {
        super(posX,posY,v,type);
    }

    @Override
    public void evoluate(long dt) {
        AreaType area = this.getCurrentAreaType();
        super.evoluate(dt);
        if(!availaibleArea.contains(area)) setVitality(getVitality()-1*dt);
    }

}