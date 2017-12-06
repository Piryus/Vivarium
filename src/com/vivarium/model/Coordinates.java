package com.vivarium.model;

/**
 * 
 */
public class Coordinates {

    /**
     * Default constructor
     */
    public Coordinates() {}

    public Coordinates(Coordinates otherCoords)
    {
        this.x=otherCoords.x;
        this.y=otherCoords.y;
    }

    private int x;
    private int y;
    /**
     * @param x 
     * @param y
     */
    public void Coordinate(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public Coordinates(int x, int y) {
        this.x=x;
        this.y=y;
    }
    /**
     * @param x
     */
    public void setX(int x) {
        this.x=x;
    }

    /**
     * @param y
     */
    public void setY(int y) {
        this.y=y;
    }

    /**
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return
     */
    public int getY() {
        return this.y;
    }

}