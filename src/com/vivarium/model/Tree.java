package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Tree extends Vegetal {

    /**
     * Default constructor
     */
    public Tree(int x, int y, Vivarium v) {
        super(x,y,v,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain})),
                10000);
    }

    @Override
    public String getSpecie() {
        return "Tree";
    }
}