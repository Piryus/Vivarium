
package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Wolf extends Carnivore {

    //private ArrayList<AreaType> suitableAreas = new ArrayList<>();
    //private AreaType currentArea;

    public Wolf(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 200, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Desert})));
        currArea = AreaType.Plain;
    }


    @Override
    public String getSpecie() {
        return "Wolf";
    }
}