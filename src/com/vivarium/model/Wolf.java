
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

        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert,AreaType.Water})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Desert})));
        currArea = AreaType.Plain;
    }

    private int coefX = 1, coefY = 1; // pour debug

    @Override
    public void evoluate(long dt) {
        this.move(dt*getSpeed()*coefX,dt*getSpeed()*coefY);

        if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() ){
            coefX = -1;
        }
        else if (this.getPos().getX()-getSize()/2 <0){
            coefX = 1;
        }
        if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() ){
            coefY = -1;
        }
        else if (this.getPos().getY()-getSize()/2<0){
            coefY = 1;
        }
    }

}