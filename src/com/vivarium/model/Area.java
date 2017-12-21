package com.vivarium.model;

import java.util.ArrayList;

public class Area {

    private AreaType type;
    private Coordinates topLeftCornerCoords;
    public static final int areaSize = 80;

    /**
     * Constructor with parameters
     * @param type the area's type (water, desert, plain, moutain ; see AreaType)
     * @param coords the coordinates of the area's top left corner
     */
    public Area(AreaType type, Coordinates coords) {
        this.type = type;
        this.topLeftCornerCoords = new Coordinates(coords);
    }

    /**
     * Getter for type
     * @return type of the area
     */
    public AreaType getAreaType() {
        return type;
    }

    /**
     * Setter for type
     * @param type of the area to set
     */
    public void setAreaType(AreaType type) {
        this.type=type;
    }

    /**
     * Getter for top left corner's coords
     * @return topLeftCornerCoords
     */
    public Coordinates getCoords() {
        return topLeftCornerCoords;
    }

    /**
     * Return an ArrayList of Area which surround the area (this)
     * @param areaList to scan 
     * @return surroundAreasList
     */
    public ArrayList<Area> getSurroundingAreas(ArrayList<Area> areaList) {
        ArrayList<Area> surroundingAreasList = new ArrayList<>();
        for(int i=0;i<areaList.size();i++) {
            if ((((areaList.get(i).getCoords().getX() == this.getCoords().getX() - areaSize) ||
                            (areaList.get(i).getCoords().getX() == this.getCoords().getX() + areaSize)) && (areaList.get(i).getCoords().getY() == this.getCoords().getY())) ||
                            (((areaList.get(i).getCoords().getY() == this.getCoords().getY() - areaSize) ||
                                    (areaList.get(i).getCoords().getY() == this.getCoords().getY() + areaSize)) && (areaList.get(i).getCoords().getX() == this.getCoords().getX()))) {
                surroundingAreasList.add(areaList.get(i));
            }
        }
        return surroundingAreasList;
    }
}