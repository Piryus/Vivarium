package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Mushroom extends Vegetal {

    /**
     * Default constructor
     */
    public Mushroom(int x, int y, Vivarium v) {
        super(x,y,v,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain})),
                10000);
    }

}