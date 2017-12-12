package com.vivarium.model;
import java.util.*;

public class Terrain {
    private final int width=2000;
    private final int height=2000;
    private ArrayList<Area> areasList;
    /**
     * Default constructor
     */
    public Terrain() {
        areasList = new ArrayList<Area>();
        generateAreas();
    }

    private void generateAreas() {
        for(int i=0;i<this.width;i+=80) {
            for(int j=0;j<this.height;j+=80) {
                areasList.add(new Area(AreaType.getRandom(),new Coordinates(i,j)));
            }
        }
    }

    /**
     * @param a 
     * @return
     */
    public Area getArea(Organism a) {
        // TODO implement here
        return null;
    }

    public ArrayList<Area> getAreasList() {
        return areasList;
    }

}