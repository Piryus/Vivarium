package com.vivarium;

import java.awt.image.BufferedImage;
import java.util.*;



/**
 * 
 */
public abstract class Organism {

    /**
     * Default constructor
     */
    public Organism() {
        id = nextid;
        nextid++;
    }
    private int id;
    private Coordinates coord ;
    private static int nextid = 0;
    private String name;
    private AreaType area;
    private BufferedImage picture;

    /**
     * constructeur
     * @param int x
     * @param int y
     */
    public void Organism(int x,int y) {
        //
        id = nextid;
        nextid++;
        coord.Coordinate(x,y);
        name ="Unnamed Organism";
    }

    /**
     * @return
     */
    public int getID() {
        // Return object's id
        return id ;
    }

    /**
     * @return
     */
    public Coordinates getPos() {
        // Return the position
        return coord;
    }
    abstract void setArea(AreaType a);
    abstract void setPicture(BufferedImage image);
    abstract void evoluate (long dt);
}