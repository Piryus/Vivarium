package com.vivarium.controller;

import com.vivarium.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class VivariumController {
    private Vivarium vivarium;
    private HashMap<Integer, Long> lastCall;
    private ArrayList<Organism> newOrganisms;
    private ArrayList<Organism> oldOrganisms;

    public VivariumController(Vivarium v){
        vivarium = v;
        lastCall = new HashMap<>();
        newOrganisms = new ArrayList<>();
        oldOrganisms = new ArrayList<>();
    }

    /**
     * permet d'ajouter un organism au VivariumCOntroller
     * @param o
     */
    public synchronized void add(Organism o){
        vivarium.add(o);
        lastCall.put(o.getID(),System.currentTimeMillis());
        newOrganisms.add(o);
    }

    /**
     * Permet d'ajouter un oranism au VivariumCOntroller
     * @param o
     */
    public synchronized void delete(Organism o){
        vivarium.delete(o);
        oldOrganisms.add(o);
    }

    /**
     * Permet de récupérer le terrain du vivarium
     * @return
     */
    public synchronized Terrain getTerrain(){
        return vivarium.getTerrain();
    }

    /**
     * Permet de récupérer la liste des organismes
     * @return
     */
    public synchronized ArrayList<Organism> getOrganisms(){
        return vivarium.getOrganisms();
    }

    /**
     * gère la boucle de jeu
     */
    public synchronized void loop(){
        long t;
        for (int i = vivarium.getOrganisms().size()-1;i>=0;i--){
            t = System.currentTimeMillis();
            Organism o = vivarium.getOrganisms().get(i);
            if (o instanceof Animal) {
                if (((Animal) o).getHP() == 0) {
                    delete(o);
                }
            }
            if (o instanceof Fish) evoluateF((Fish)o,t - lastCall.get(o.getID()));
            else if (o instanceof Herbivore) evoluateH((Herbivore)o,t - lastCall.get(o.getID()));
            else if (o instanceof Carnivore) evoluateC((Carnivore) o,t - lastCall.get(o.getID()));
            else if (o instanceof Vegetal) evoluateV((Vegetal) o,t - lastCall.get(o.getID()));
            lastCall.replace(o.getID(), t);
        }
    }

    /**
     * Permet de récupérer la liste des organism nouvellement créé. Cette liste permet au VivariumRenderer de créé les vues correspondantes
     * @return
     */
    public synchronized ArrayList<Organism> getNewOrganisms() {
        return newOrganisms;
    }

    /**
     * Permet de récupérer la liste des organism récemment effacé. Cette liste permet au VivariumRenderer de suprimer les vues correspondantes
     * @return
     */
    public synchronized ArrayList<Organism> getOldOrganisms() {
        return oldOrganisms;
    }

    /**
     * Permet de supprimer le contenu de newOrganisms et oldOrganism une fois que la vue à mis à jour le contenu de ces Organisms
     */
    public synchronized void clearOldNew(){
        newOrganisms.clear();
        oldOrganisms.clear();
    }

    public synchronized Vivarium getVivarium() {
        return vivarium;
    }

    /** Méthode qui gere le comportement des herbivore**/



    public void evoluateH(Herbivore h,long dt) 
    {
        h.setHunger(h.getHunger()+0.001f);
        Coordinates c0 = new Coordinates(0,0);
        Coordinates c=h.getCoordDanger(100);
        AreaType area = h.getCurrentAreaType();
        if(!h.getAvailaibleArea().contains(area)) h.setHP(h.getHP()-h.getVitality()*dt);
        if(h.getHunger()>= 10) h.setHP(h.getHP()-h.getVitality()*dt);
        if(h.getHunger()<=4) h.setHP(h.getHP()+h.getVitality()*dt);

        // si danger
        if (c.getX() != c0.getX() || c.getY() != c0.getY() ){
            h.move(dt*h.getSpeed()*c.getX(),dt*h.getSpeed()*c.getY());
            return;
        }
        // si faim
        if(h.isHungry())
        {
          h.lookForFood(dt);
        }
        else //sinon
        {
            Animal a = h.lookForMate(dt);
            if (a != null){
                this.add(a);
            }
        }
    }
    public void evoluateC(Carnivore c,long dt)
    {
        //int coefX=1; int coefY =1;
        //int[] coefs = new int[2];

        AreaType area = c.getCurrentAreaType();
        if(!c.getAvailaibleArea().contains(area))
        {
            c.setHP(c.getHP()-c.getVitality()*dt);
        }
        if(c.getHunger()>= 10)
        {
            c.setHP(c.getHP()-c.getVitality()*dt);
        }
        if(c.getHunger()<=4)
        {
            c.setHP(c.getHP()+c.getVitality()*dt);
        }

        if(c.isHungry())
        {
            c.lookForFood(dt);
            //coefX = coefs[0];
            //coefY = coefs[1];
        }
        else
        {
            Animal a = c.lookForMate(dt);
            if (a!=null){
                this.add(a);
            }
            //coefX = coefs[0];
            //coefY = coefs[1];
        }
        c.setHunger(c.getHunger()+(0.001f * dt ));
        //c.move(dt * c.getSpeed() * coefX, dt * c.getSpeed() * coefY);

    }


    public void evoluateV (Vegetal v ,long dt){
        if (!v.getEdible()){
            v.setTimeSinceEaten(v.getTimeSinceEaten()+ dt);
            if (v.getTimeSinceEaten() > v.getRespawnTime()) {
                v.setEdible(true);
                v.setTimeSinceEaten(0);
            }
        }
    }

    public void evoluateF (Fish f, long dt){
        AreaType area = f.getCurrentAreaType();
        if (area != null)
            if(!area.equals(AreaType.Water)) f.setHP(f.getHP()-f.getVitality()*dt);
                f.move(dt);
    }

    public synchronized Organism getOrganismAtPos(double posX, double posY){
        return vivarium.getOrganismAtPos(posX,posY);
    }
}
