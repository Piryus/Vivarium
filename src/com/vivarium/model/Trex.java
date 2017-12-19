package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Trex extends Carnivore {

    public Trex(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 2500, 0, 0.15f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Desert})));
        currArea = AreaType.Plain;

    }



}