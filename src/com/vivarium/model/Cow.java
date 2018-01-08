package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Cow extends Herbivore {

    /**
     * Default constructor
     */
    public Cow(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain})));
        currArea = AreaType.Plain;
    }


    @Override
    public String getSpecie() {
        return "Cow";
    }
}