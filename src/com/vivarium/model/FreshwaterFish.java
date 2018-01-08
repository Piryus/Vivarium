package com.vivarium.model;

/**
 * 
 */
public class FreshwaterFish extends Fish {

    /**
     * Default constructor
     */
    public FreshwaterFish(int posX,int posY,Vivarium v, Sex type) {
        super(posX,posY,v,type);
    }


    @Override
    public String getSpecie() {
        return "FreshwaterFish";
    }
}