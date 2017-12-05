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
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private static int nextid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private AreaType area;

    /**
     * 
     */
    private BufferedImage picture;





    /**
     * @param int x 
     * @param int y
     */
    public void Organism(int x,int y) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Coordinates getPos() {
        // TODO implement here
        return null;
    }

}