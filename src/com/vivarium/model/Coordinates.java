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

    /*
    * Renvoie true si other est plus proche que repere
    * */
    public boolean isCloser(Coordinates other,Coordinates repere)
    {
        double repereX = (double) repere.getX();
        double repereY = (double) repere.getY();
        double otherX = (double) other.getX();
        double otherY = (double) other.getY();
        double thisX = (double) this.getX();
        double thisY = (double) this.getY();

        return (Math.sqrt(Math.pow((otherX-thisX),2)+Math.pow(otherY+thisY,2))) < (Math.sqrt(Math.pow((repereX-thisX),2)+Math.pow((repereY-thisY),2)));
    }

    private int x;
    private int y;
    /**
     * @param x 
     * @param y
     */

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