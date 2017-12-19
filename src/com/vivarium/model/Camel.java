package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Camel extends Herbivore {

    /**
     *  constructor
     */
    public Camel(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 100, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain, AreaType.Desert})),
                new ArrayList<>(Arrays.asList(new AreaType[]{ AreaType.Plain})));
        currArea = AreaType.Desert;
    }
    /** Méthode qui renvoie true si hunger et inf a 5 et false sinon **/
    public boolean isHungry()
    {
        return getHunger()>=5;
    }


    /** Méthode qui  gere la recherche de nourrture ici de vegetal **/
    public void lookForFood(long dt)
    {
        double coefX=0;
        double coefY=0;
        Organism prey = this.vivarium.getCloser(this, 'v');
        if(prey != null)
        {
            if(prey.getPos().getX()<this.getPos().getX())
            {
                coefX = -1;
            }
            else
            {
                coefX =1;
            }
            if(prey.getPos().getY()<this.getPos().getY())
            {
                coefY =-1;
            }
            else
            {
                coefY=1;
            }
            if(this.getPos().equals(prey.getPos()))
            {
                this.eat((Vegetal) prey);
            }
        }
        else
        {
            if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() ){
                coefX = -1;
            }
            else if (this.getPos().getX()-getSize()/2  <0){
                coefX = 1;
            }
            if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() ){
                coefY = -1;
            }
            else if (this.getPos().getY()-getSize()/2 <0){
                coefY = 1;
            }
        }
        if (coefX != 0 & coefY != 0) {
            this.move(dt * getSpeed() * coefX, dt * getSpeed() * coefY);
        }


    }
    /** Méthode qui gere la recherche  d' animeux de la meme espéce mais d'un autre sex dans un but de reproduction **/
    public void lookForMate(long dt) {
        double coefX = 0;
        double coefY = 0;
        Animal mate = this.vivarium.scanOtherGender(this);
        if (mate != null) {
            if (mate.getPos().getX() == this.getPos().getX() & mate.getPos().getY() == this.getPos().getY()) {// todo : accouplement}
                if (mate.getPos().getX() < this.getPos().getX()) {
                    coefX = -1;
                } else {
                    coefX = 1;
                }
                if (mate.getPos().getY() < this.getPos().getY()) {
                    coefY = -1;
                } else {
                    coefY = 1;
                }


            } else {
                if (this.getPos().getX() + getSize() / 2 > vivarium.getTerrain().getWidth()) {
                    coefX = -1;
                } else if (this.getPos().getX() - getSize() / 2 < 0) {
                    coefX = 1;
                }
                if (this.getPos().getY() + getSize() / 2 > vivarium.getTerrain().getHeight()) {
                    coefY = -1;
                } else if (this.getPos().getY() - getSize() / 2 < 0) {
                    coefY = 1;
                }
            }

            if (coefX != 0 & coefY != 0) {
                this.move(dt * getSpeed() * coefX, dt * getSpeed() * coefY);
            }
        }
    }

    /** Méthode qui gere le comportement de camel**/



    public void evoluate(long dt) // methode expérimental a tester pour implémentation ultérieur dans les autres class
    {
        this.setHunger(this.hunger+0.005f);
        Coordinates c0 = new Coordinates(0,0);
        Coordinates c=isDanger(100);
        if (c.getX() != c0.getX() || c.getY() != c0.getY() ){
            this.move(dt*getSpeed()*c.getX(),dt*getSpeed()*c.getY());
        return;
        }
        if(this.isHungry())
        {
            this.lookForFood(dt);
        }
        else
        {
            this.lookForMate(dt);
        }
    }



}
