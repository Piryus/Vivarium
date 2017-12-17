package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Grass extends Vegetal {

    /**
     * constructor
     */
    public Grass(int x, int y, Vivarium v) {
        super(x,y,v,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain})),
                10000);
    }

}