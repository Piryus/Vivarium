package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Bouquetin extends Herbivore {

    /**
     * Default constructor
     */
    public Bouquetin(int posX,int posY,Vivarium v, Sex type) { // TODO
        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain,})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain,})));
        currArea = AreaType.Plain;
    }

    @Override
    public void evoluate(long dt) {
        super.evoluate(dt);

    }

}