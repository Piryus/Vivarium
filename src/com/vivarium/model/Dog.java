package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Dog extends Carnivore {

    public Dog(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 5, 0, 0.01f, 0.03f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Desert})));
        currArea = AreaType.Plain;
    }

    @Override
    public String getSpecie() {
        return "Dog";
    }
}