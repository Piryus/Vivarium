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

    private double x;
    private double y;
    /**
     * @param x 
     * @param y
     */

    public Coordinates(double x, double y) {
        this.x=x;
        this.y=y;
    }
    /**
     * @param x
     */
    public void setX(double x) {
        this.x=x;
    }

    /**
     * @param y
     */
    public void setY(double y) {
        this.y=y;
    }

    /**
     * @return
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return
     */
    public double getY() {
        return this.y;
    }

}