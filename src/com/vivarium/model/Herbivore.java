package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public abstract class Herbivore extends Animal {

    /**
     * Default constructor
     */
    public Herbivore(int posX, int posY, Vivarium v, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> avArea, ArrayList<AreaType> dfArea) {
        super( posX, posY, v, health,  hunger,  vitality, speed, type, avArea, dfArea);
    }

    /**
     * @param a 
     * @return
     */
    public Boolean eat(Vegetal a) {
            if (a.getEdible()){
                a.setEdible(false);
                this.setHunger(0);
                return true;

            }
        return false;
    }


    /**  *renvoie la position du pradateur le plus proche dans un rayon dist et sinon (0,0)  (de toute facon si le prédateur
     *à la même position l'herbivore sera mangé
     **/
    public Coordinates isDanger (double dist){
        Organism o =null;
        Coordinates c=new Coordinates(0,0);
        if (this.vivarium.getCloser(this,'c')==null) return c ;
        o= this.vivarium.getCloser(this,'c');
        double oX = (double) o.getPos().getX();
        double oY = (double) o.getPos().getY();
        double thisX = (double) this.getPos().getX();
        double thisY = (double) this.getPos().getY();
        if((Math.sqrt(Math.pow((oX-thisX),2)+Math.pow(oY+thisY,2)))>dist){
            if(thisX>oX) c.setX(-1);
            else c.setX(1);

            if(thisY>oY) c.setX(-1);
            else c.setX(1);
            return c;
        }
        return c;
    }

}