package com.vivarium.model;
import java.util.*;

import static com.vivarium.model.Area.areaSize;

public class Terrain {
    private final int width=3000;
    private final int height=3000;
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
     * Default Constructor, initialize areasList, call generateAreas();
     * @see Terrain#generateAreas()
     */
    public Terrain() {
        areasList = new ArrayList<Area>();
        generateAreas();
        //generateAreasFromMap();
    }

    /**
     * Generates random AreaType for each tile (80*80) then run a filter to avoid having an isolated tile of water, desert or moutain
     * If an isolated area is found, its type is set to plain
     */
    private void generateAreas() {
        // Generate areas with random AreaType
        for (int i = 0; i < this.width; i += areaSize) {
            for (int j = 0; j < this.height; j += areaSize) {
                areasList.add(new Area(AreaType.getRandom(), new Coordinates(i, j)));
            }
        }

        // If letAlive is false at the end of the loop, the area type will be set to plain
        boolean letAlive;

        // Checks whether an area is isolated or not (loop to check all areas of the terrain)
        for (int i = 0; i < areasList.size(); i++) {
            letAlive = false;
            switch (areasList.get(i).getAreaType()) {

                case Water:
                    for (int j = 0; j < areasList.get(i).getSurroundingAreas(areasList).size(); j++) {
                        if (areasList.get(i).getSurroundingAreas(areasList).get(j).getAreaType() == AreaType.Water) {
                            // A surrounding water area was found, this area will not be changed
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
                            // A surrounding mountain area was found, this area will not be changed
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
                            // A surrounding desert area was found, this area will not be changed
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

    /**
     * Generate areas from a map of int
     * 0 = Moutain ; 1 = Plain ; 2 = Water ; 3 = Desert
     * UNUSED for the moment, will be used to create custom map
     */
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
                areasList.add(new Area(areaType,new Coordinates(i*areaSize,j*areaSize)));
            }
        }
    }


    /**
     * Getter for areasList
     * @return areasList
     */
    public ArrayList<Area> getAreasList() {
        return areasList;
    }

    /**
     * Getter for terrain's height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for terrain's width
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Return a random terrain's area of a certain passed type
     * Used to spawn animals on desired area's type
     * @param areaType the desired type of the area
     * @return terrain's area of a certain passed type
     */
    public Area getRandomAreaOfType(AreaType areaType) {
        Random rand =  new Random();
        int pickedRandomInt = rand.nextInt(areasList.size());
        while(areasList.get(pickedRandomInt).getAreaType()!=areaType) {
            pickedRandomInt = rand.nextInt(areasList.size());
        }
        return areasList.get(pickedRandomInt);
    }
}