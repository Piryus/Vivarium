package com.vivarium.model;
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
    /*
    public void loop() {
        long t;
        for (Organism o: organisms)
        {
            t = System.currentTimeMillis();
            o.evoluate(t-lastCall.get(o.getID()));
            lastCall.replace(o.getID(),t);
        }
    }
    */
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

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }

    public  Organism scan (Organism src, char a){
        Organism o= null;
        ArrayList<Organism> dispo=null;
        if (a=='h'){
            for(int j=0;j<(getOrganisms().size()); j++){
                if (getOrganisms().get(j) instanceof Herbivore){
                    dispo.add(getOrganisms().get(j));

                }
            }
        }
        if (a=='c'){
            for(int j=0;j<(getOrganisms().size()); j++){
                if (getOrganisms().get(j) instanceof Carnivore){
                    dispo.add(getOrganisms().get(j));

                }
            }
        }
        if (a=='v'){
            for(int j=0;j<(getOrganisms().size()); j++){
                if (getOrganisms().get(j) instanceof Vegetal){
                    dispo.add(getOrganisms().get(j));

                }
            }
        }
        o=dispo.get(0);
        for (int i=1;i<dispo.size();i++){
            if (src.getPos().isCloser(dispo.get(i).getPos(),o.getPos())){
                o=dispo.get(i);
            }
        }

        return o;}

}