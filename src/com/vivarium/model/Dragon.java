package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Dragon extends Carnivore {

    public Dragon(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 1200, 0, 0.15f, 0.15f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{})));
        currArea = AreaType.Plain;
    }


    @Override
    public String getSpecie() {
        return "Dragon";
    }
}