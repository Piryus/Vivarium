package com.vivarium.model;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Eagle extends Carnivore
{

    private int coefX = 1, coefY = 1; // pour debug
    public Eagle(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 50, 0, 0.05f, 0.10f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert,AreaType.Water})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Desert})));
        currArea = AreaType.Mountain;
    }



}