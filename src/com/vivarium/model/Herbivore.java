package com.vivarium.model;

import java.util.ArrayList;

/**
 * 
 */
public class Herbivore extends Animal {

    /**
     * Default constructor
     */
    public Herbivore(int posX, int posY, Vivarium v, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> avArea, ArrayList<AreaType> dfArea) {
        super(posX, posY, v, health, hunger, vitality, speed, type, avArea, dfArea);
    }

    /**
     * @param a
     * @return
     */
    public Boolean eat(Vegetal a) {
        if (a.getEdible()) {
            a.setEdible(false);
            this.setHunger(0);
            return true;

        }
        return false;
    }


    /**
     * renvoie la position du pradateur le plus proche dans un rayon dist et sinon (0,0)  (de toute facon si le prédateur
     * à la même position l'herbivore sera mangé
     **/
    public Coordinates getCoordDanger(double dist) {
        Organism o = null;
        Coordinates c = new Coordinates(0, 0);
        if (this.vivarium.getCloser(this, 'c') == null) return c;
        o = this.vivarium.getCloser(this, 'c');
        double oX = (double) o.getPos().getX();
        double oY = (double) o.getPos().getY();
        double thisX = (double) this.getPos().getX();
        double thisY = (double) this.getPos().getY();
        if ((Math.sqrt(Math.pow((oX - thisX), 2) + Math.pow(oY + thisY, 2))) > dist) {
            if (thisX > oX) {
                c.setX(1);
            } else {
                c.setX(-1);
            }

            if (thisY > oY) {
                c.setY(1);
            } else {
                c.setY(-1);
            }

            return c;
        }
        return c;
    }

    /**
     * Méthode qui renvoie true si hunger et inf a 5 et false sinon
     **/
    public boolean isHungry() {
        return getHunger() >= 5;
    }


    /**
     * Méthode qui  gere la recherche de nourrture ici de vegetal
     **/
    public void lookForFood(long dt) {
        double coefX = 0;
        double coefY = 0;
        Organism prey = this.vivarium.getCloser(this, 'v');
        if (prey != null) {
            if (prey.getPos().getX() < this.getPos().getX()) {
                coefX = -1;
            } else {
                coefX = 1;
            }
            if (prey.getPos().getY() < this.getPos().getY()) {
                coefY = -1;
            } else {
                coefY = 1;
            }
            if (this.getPos().equals(prey.getPos())) {
                this.eat((Vegetal) prey);
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

    /**
     * Méthode qui gere la recherche  d' animeux de la meme espéce mais d'un autre sex dans un but de reproduction
     **/
    public void lookForMate(long dt) {
        System.out.print("cherche a se reproduire \n");
        double coefX = 0;
        double coefY = 0;
        Animal mate = this.vivarium.scanOtherGender(this);
        if (mate != null) {
            if (mate.getPos().getX() == this.getPos().getX() & mate.getPos().getY() == this.getPos().getY()) {
                System.out.print("se reproduit \n");
            }// todo : accouplement
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




    /** Méthode qui gere le comportement de camel**/



    public void evoluate(long dt) // methode expérimental a tester pour implémentation ultérieur dans les autres class
    {
        this.setHunger(this.hunger+0.005f);
        Coordinates c0 = new Coordinates(0,0);
        Coordinates c=getCoordDanger(100);
        AreaType area = this.getCurrentAreaType();
        if(!availaibleArea.contains(area)) setHP(getHP()-getVitality()*dt);
        if(getHunger()>= 10) setHP(getHP()-getVitality()*dt);
        if(getHunger()<=4) setHP(getHP()+getVitality()*dt);

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