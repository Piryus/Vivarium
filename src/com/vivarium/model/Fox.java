package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Fox extends Carnivore {

    public Fox(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 70, 0, 0.05f, 0.07f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Desert})));
        currArea = AreaType.Plain;

    }

    @Override
    public void evoluate(long dt) {
        super.evoluate(dt);
    }

}