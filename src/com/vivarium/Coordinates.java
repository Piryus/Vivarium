package com.vivarium;
import java.util.*;

/**
 * 
 */
public class Coordinates {

    /**
     * Default constructor
     */
    public Coordinates() {
    }

    private int x;
    private int y;
    /**
     * @param x 
     * @param y
     */
    public void Coordinate(int x, int y) {
        // TODO implement here
        this.x=x;
        this.y=y;
    }

    /**
     * @param x
     */
    public void setX(int x) {
        // TODO implement here
        this.x=x;
    }

    /**
     * @param y
     */
    public void setY(int y) {
        // TODO implement here
        this.y=y;
    }

    /**
     * @return
     */
    public int getX() {
        // TODO implement here
        return this.x;
    }

    /**
     * @return
     */
    public int getY() {
        // TODO implement here
        return this.y;
    }

}