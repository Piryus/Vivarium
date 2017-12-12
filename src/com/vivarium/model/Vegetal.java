package com.vivarium.model;

/**
 * 
 */
public abstract class Vegetal extends Organism {

    /**
     * Default constructor
     */
    public Vegetal() {
        super();
    }

    /**
     * 
     */
    private Boolean isEdible;
    /**
     * 
     */
    private int respawnTime;
    /**
     * 
     */
    public boolean getEdible(){
        return isEdible;
    }
    public void setEdible(boolean b){
        this.isEdible=b;
    }


}