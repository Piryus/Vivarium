package com.vivarium.model;

import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * 
 */
public abstract class Herbivore extends Animal {

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
            if (abs(prey.getPos().getX()-this.getPos().getX())<2 && abs(prey.getPos().getY()-this.getPos().getY())<2) {

                this.eat((Vegetal)prey);
                this.setHunger(this.hunger-2.0f);
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
     * Méthode qui gere la recherche  d' animaux de la meme espèce mais d'un autre sexe dans un but de reproduction
     * @return un nouveau animal si la recherche est fructueuse
     **/
    public Animal lookForMate(long dt) {
        Animal petit = null;
        double coefX = 0;
        double coefY = 0;
        Animal mate = this.vivarium.scanOtherGender(this);
        if (mate != null) {
            if (abs(mate.getPos().getX()-this.getPos().getX())<2 && abs(mate.getPos().getY()-this.getPos().getY())<2) {
                System.out.print("se reproduit \n");
                this.hunger += 4;
                if (type == Sex.Female)
                    try{
                        petit = OrganismFactory.AnimalFactory(getSpecie(),(int)this.getPos().getX(), (int)this.getPos().getY(), vivarium,Sex.getRandom());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

            }
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


        }
        else
        {
            //System.out.println("je suis seul.e au monde :'(");
            if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() )
            {
                coefX = -1;
            }
            else if (this.getPos().getX()-getSize()/2 <0)
            {
                coefX = 1;
            }
            if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() )
            {
                coefY = -1;
            }
            else if (this.getPos().getY()-getSize()/2<0)
            {
                coefY = 1;
            }
        }

        

        if (coefX != 0 & coefY != 0) {
            this.move(dt * getSpeed() * coefX, dt * getSpeed() * coefY);
        }
        return petit;
    }






}