package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public abstract class Vegetal extends Organism {

    private float timeSinceEaten;
    private Boolean isEdible;
    private int respawnTime;

    /**
     * Default constructor
     */
    public Vegetal() {
        super();
    }
    public Vegetal(int x,int y, Vivarium v, ArrayList<AreaType> avArea, int respawnTime) {
        super(x,y,v,avArea);
        this.respawnTime = respawnTime;
        isEdible = true;
    }


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