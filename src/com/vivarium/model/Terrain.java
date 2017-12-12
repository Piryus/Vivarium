package com.vivarium.model;
import java.util.*;

public class Terrain {
    private final int width=2000;
    private final int height=2000;
    private ArrayList<Area> areasList;
    private int[][] map = {
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3},
            {0,0,0,0,1,1,1,1,2,2,2,2,2,1,1,1,3,3,3,1,2,3,3,3,3}
    };
    /**
     * Default constructor
     */
    public Terrain() {
        areasList = new ArrayList<Area>();
        generateAreas();
        //generateAreasFromMap();
    }

    /* Generates random AreaType for each tile (80*80) then run cellular automata rules x times */
    private void generateAreas() {
        boolean letAlive = false;
        for (int i = 0; i < this.width; i += 80) {
            for (int j = 0; j < this.height; j += 80) {
                areasList.add(new Area(AreaType.getRandom(), new Coordinates(i, j)));
            }
        }
        for (int i = 0; i < areasList.size(); i++) {
            letAlive = false;
            switch (areasList.get(i).getAreaType()) {
                case Water:
                    for (int j = 0; j < areasList.get(i).getSurroundingAreas(areasList).size(); j++) {
                        if (areasList.get(i).getSurroundingAreas(areasList).get(j).getAreaType() == AreaType.Water) {
                            letAlive = true;
                        }
                    }
                    if (!letAlive) {
                        areasList.get(i).setAreaType(AreaType.Plain);
                    }
                    break;
                case Mountain:
                    for (int j = 0; j < areasList.get(i).getSurroundingAreas(areasList).size(); j++) {
                        if (areasList.get(i).getSurroundingAreas(areasList).get(j).getAreaType() == AreaType.Mountain) {
                            letAlive = true;
                        }
                    }
                    if (!letAlive) {
                        areasList.get(i).setAreaType(AreaType.Plain);
                    }
                    break;
                case Desert:
                    for (int j = 0; j < areasList.get(i).getSurroundingAreas(areasList).size(); j++) {
                        if (areasList.get(i).getSurroundingAreas(areasList).get(j).getAreaType() == AreaType.Desert) {
                            letAlive = true;
                        }
                    }
                    if (!letAlive) {
                        areasList.get(i).setAreaType(AreaType.Plain);
                    }
                    break;
            }
        }
    }

    private void generateAreasFromMap() {
        AreaType areaType = null;
        for(int i=0;i<25;i++) {
            for(int j=0;j<25;j++) {
                switch(map[i][j]) {
                    case 0:
                        areaType= AreaType.Mountain;
                        break;
                    case 1:
                        areaType= AreaType.Plain;
                        break;
                    case 2:
                        areaType= AreaType.Water;
                        break;
                    case 3:
                        areaType= AreaType.Desert;
                        break;
                }
                areasList.add(new Area(areaType,new Coordinates(i*80,j*80)));
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