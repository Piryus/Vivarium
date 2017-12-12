package com.vivarium.model;


/**
 * 
 */
public abstract class Organism {
    private int id;
    private Coordinates position ;
    private static int nextid = 0;
    private String name;
    private AreaType area;
    /**
     * Default constructor
     */
    public Organism() {
        id = nextid;
        nextid++;
    }

    /**
     * constructeur
     * @param
     * @param
     */
    public Organism(int x,int y) {
        //
        this.id = nextid;
        nextid++;
        this.position=new Coordinates(x,y);
        this.name ="Unnamed Organism";
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
        return position;
    }
    abstract void setArea(AreaType a);
    abstract void evoluate (long dt);
}