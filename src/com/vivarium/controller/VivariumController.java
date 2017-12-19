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

    public synchronized void add(Organism o){
        vivarium.add(o);
        lastCall.put(o.getID(),System.currentTimeMillis());
        newOrganisms.add(o);
    }

    public synchronized void delete(Organism o){
        vivarium.delete(o);
        oldOrganisms.add(o);
    }

    public synchronized Terrain getTerrain(){
        return vivarium.getTerrain();
    }

    public synchronized ArrayList<Organism> getOrganisms(){
        return vivarium.getOrganisms();
    }

    public synchronized void loop(){
        long t;
        /*
        for (Organism o: vivarium.getOrganisms()) {
            t = System.currentTimeMillis();
            if (o instanceof Animal) {
                if (((Animal) o).getHP() == 0) {
                    delete(o);
                }
            }
            o.evoluate(t - lastCall.get(o.getID()));
            lastCall.replace(o.getID(), t);
        }*/

        for (int i = vivarium.getOrganisms().size()-1;i>=0;i--){
            t = System.currentTimeMillis();
            Organism o = vivarium.getOrganisms().get(i);
            if (o instanceof Animal) {
                if (((Animal) o).getHP() == 0) {
                    delete(o);
                }
            }
            if (o instanceof Herbivore) evoluateH((Herbivore)o,t - lastCall.get(o.getID()));
            else if (o instanceof Carnivore) evoluateC((Carnivore) o,t - lastCall.get(o.getID()));
            else if (o instanceof Vegetal) evoluateV((Vegetal) o,t - lastCall.get(o.getID()));
            lastCall.replace(o.getID(), t);
        }
    }

    public synchronized ArrayList<Organism> getNewOrganisms() {
        return newOrganisms;
    }

    public synchronized ArrayList<Organism> getOldOrganisms() {
        return oldOrganisms;
    }

    public synchronized void clearOldNew(){
        newOrganisms.clear();
        oldOrganisms.clear();
    }

    public synchronized Vivarium getVivarium() {
        return vivarium;
    }

    /** Méthode qui gere le comportement des herbivore**/



    public void evoluateH(Herbivore h,long dt) // methode expérimental a tester pour implémentation ultérieur dans les autres class
    {
        h.setHunger(h.getHunger()+0.005f);
        Coordinates c0 = new Coordinates(0,0);
        Coordinates c=h.getCoordDanger(100);
        AreaType area = h.getCurrentAreaType();
        if(!h.getAvailaibleArea().contains(area)) h.setHP(h.getHP()-h.getVitality()*dt);
        if(h.getHunger()>= 10) h.setHP(h.getHP()-h.getVitality()*dt);
        if(h.getHunger()<=4) h.setHP(h.getHP()+h.getVitality()*dt);

        if (c.getX() != c0.getX() || c.getY() != c0.getY() ){
            h.move(dt*h.getSpeed()*c.getX(),dt*h.getSpeed()*c.getY());
            return;
        }
        if(h.isHungry())
        {
          h.lookForFood(dt);
        }
        else
        {
            h.lookForMate(dt);
        }
    }
    public void evoluateC(Carnivore c,long dt)
    {   c.move(dt * c.getSpeed() * c.getCoefX(), dt * c.getSpeed() * c.getCoefY());
        System.out.print("evoluateC");
        AreaType area = c.getCurrentAreaType();
        if(!c.getAvailaibleArea().contains(area)) c.setHP(c.getHP()-c.getVitality()*dt);
        if(c.getHunger()>= 10) c.setHP(c.getHP()-c.getVitality()*dt);
        if(c.getHunger()<=4) c.setHP(c.getHP()+c.getVitality()*dt);
        if(c.isHungry())
        {
            System.out.print("lookForfood");
            c.lookForFood(c);
        }
        else
        {
            c.lookForMate(c);
        }
        c.setHunger(c.getHunger()+(0.005f * dt ));
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
}
