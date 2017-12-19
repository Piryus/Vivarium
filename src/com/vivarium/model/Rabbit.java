package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Rabbit extends Herbivore {

    /**
     *  constructor
     */
    public Rabbit(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 10, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain})));
        currArea = AreaType.Plain;
    }

    @Override
    public void evoluate(long dt) {
        AreaType area = this.getCurrentAreaType();
        super.evoluate(dt);
        if(!availaibleArea.contains(area)) setVitality(getVitality()-1*dt);
    }

}