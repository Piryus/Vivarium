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