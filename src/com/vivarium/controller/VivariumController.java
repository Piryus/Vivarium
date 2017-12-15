package com.vivarium.controller;

import com.vivarium.model.Organism;
import com.vivarium.model.Terrain;
import com.vivarium.model.Vivarium;
import com.vivarium.model.Animal;

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

    public void add(Organism o){
        vivarium.add(o);
        lastCall.put(o.getID(),System.currentTimeMillis());
        newOrganisms.add(o);
    }

    public void delete(Organism o){
        vivarium.delete(o);
        oldOrganisms.add(o);
    }

    public Terrain getTerrain(){
        return vivarium.getTerrain();
    }

    public ArrayList<Organism> getOrganisms(){
        return vivarium.getOrganisms();
    }

    public void loop(){
        long t;
        synchronized(this){
            for (Organism o: vivarium.getOrganisms()){
                t = System.currentTimeMillis();
                if (o instanceof Animal){
                    if (((Animal)o).getHP() == 0){
                        delete(o);
                    }
                }
                o.evoluate(t-lastCall.get(o.getID()));
                lastCall.replace(o.getID(), t);
            }
        }

    }

    public ArrayList<Organism> getNewOrganisms() {
        return newOrganisms;
    }

    public ArrayList<Organism> getOldOrganisms() {
        return oldOrganisms;
    }

    public void clearOldNew(){
        newOrganisms.clear();
        oldOrganisms.clear();
    }

    public Vivarium getVivarium() {
        return vivarium;
    }
}