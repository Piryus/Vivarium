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

    private float timeSinceEaten;


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

    @Override
    public void evoluate (long dt){
        if (!isEdible){
            timeSinceEaten+= dt;
            if (timeSinceEaten > respawnTime) {
                isEdible = true;
                timeSinceEaten = 0;
            }
        }
    }


}