package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Camel extends Herbivore {

    /**
     *  constructor
     */
    public Camel(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain})));
        currArea = AreaType.Desert;
    }
    public void evoluate(long dt) {
        AreaType area = this.getCurrentAreaType();
        super.evoluate(dt);
        if(!availaibleArea.contains(area)) setVitality(getVitality()-1*dt);
    }



}
