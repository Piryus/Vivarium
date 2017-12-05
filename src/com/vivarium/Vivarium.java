package com.vivarium;
import java.util.*;

/**
 * 
 */
public class Vivarium {

    private ArrayList<Organism> organisms;
    private Terrain terrain;
    private HashMap<Integer, Long> lastCall;
    /**
     * Default constructor
     */
    public Vivarium() {
        organisms = new ArrayList<>();
        terrain = new Terrain();
        lastCall = new HashMap<>();
    }





    /**
     * 
     */
    public void loop() {
        long t;
        for (Organism o: organisms)
        {
            t = System.currentTimeMillis();
            o.evoluate(t-lastCall.get(o.getID()));
            lastCall.replace(o.getID(),t);
        }

    }

    /**
     * @param o
     */
    public void add(Organism o) {
        organisms.add(o);
        lastCall.put(o.getID(),System.currentTimeMillis());
    }

    /**
     * @param o
     */
    public void delete(Organism o) {
        organisms.remove(o);
    }

    /**
     * @return
     */
    public Terrain getTerrain() {
        return terrain;
    }

}