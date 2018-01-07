package com.vivarium.model;

import java.util.ArrayList;

public abstract class Organism {

    private int id;
    private Coordinates position ;
    private static int nextid = 0;
    private String name;
    protected ArrayList<AreaType> availaibleArea;
    protected Vivarium vivarium;
    private int size;

    /**
     * Default constructor
     */
    public Organism() {
        id = nextid;
        nextid++;
    }

    /**
     * Constructor with parameters
     * @param x abscissa of the organism's position
     * @param y ordinate of the organism's position
     * @param size organism's size
     * @param v vivarium in which the organism will evolve
     * @param avArea ?? //TODO Comment
     */
    public Organism(int x,int y, int size,Vivarium v, ArrayList<AreaType> avArea) {
        vivarium = v;
        this.id = nextid;
        nextid++;
        this.position=new Coordinates(x,y);
        this.name ="Unnamed Organism";
        availaibleArea = avArea;
        this.size = size;
    }

    /**
     *
     * @param x
     * @param y
     * @param v
     * @param avArea
     */
    public Organism(int x,int y, Vivarium v, ArrayList<AreaType> avArea) {
        this(x,y,50,v,avArea);
    }

    /**
     * @return
     */
    public int getID() {
        // Return object's id
        return id ;
    }

    public int getSize(){ return size;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public Coordinates getPos() {
        // Return the position
        return position;
    }

    /**
     * @return the type of the area where the organism currently is
     */
    public AreaType getCurrentAreaType() {
        AreaType CurrentAreaType = null;
        for(int i=0;i<vivarium.getTerrain().getAreasList().size();i++) {
            if((this.getPos().getX()>vivarium.getTerrain().getAreasList().get(i).getCoords().getX()&&this.getPos().getX()<=vivarium.getTerrain().getAreasList().get(i).getCoords().getX()+80)&&
                    (this.getPos().getY()>vivarium.getTerrain().getAreasList().get(i).getCoords().getY()&&this.getPos().getY()<=vivarium.getTerrain().getAreasList().get(i).getCoords().getY()+80)) {
                CurrentAreaType = vivarium.getTerrain().getAreasList().get(i).getAreaType();
            }
        }
        return CurrentAreaType;
    }



    public ArrayList<AreaType> getAvailaibleArea() {
        return availaibleArea;
    }
}