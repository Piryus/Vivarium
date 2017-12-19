package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Bear extends Carnivore {


    public Bear(int posX, int posY, Vivarium v, Sex type) {

        super(posX, posY, v, 200, 0, 0.10f, 0.025f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain})));
        currArea = AreaType.Mountain;
    }
}