package com.vivarium.model;

/**
 * 
 */
public class Blowfish extends Fish {

    /**
     * Default constructor
     */
    public Blowfish(int posX,int posY,Vivarium v, Sex type) {
        super(posX,posY,v,type);
    }


    @Override
    public String getSpecie() {
        return "Bloxfish";
    }
}