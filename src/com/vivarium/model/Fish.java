package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public abstract class Fish extends Herbivore {

    /**
     * Default constructor
     */
    public Fish(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Water})),
                new ArrayList<>(Arrays.asList(new AreaType[]{})));
        currArea = AreaType.Water;
    }

}