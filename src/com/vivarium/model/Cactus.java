package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Cactus extends Vegetal {

    /**
     * Default constructor
     */
    public Cactus(int x, int y, Vivarium v) {
        super(x,y,v,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Desert})),
                10000);
    }

    @Override
    public String getSpecie() {
        return "Cactus";
    }
}