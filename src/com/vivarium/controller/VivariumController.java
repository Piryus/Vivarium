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
            o.evoluate(t - lastCall.get(o.getID()));
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
}
