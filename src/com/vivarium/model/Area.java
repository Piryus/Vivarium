package com.vivarium.model;


import com.vivarium.view.AreaView;

import java.util.ArrayList;

public class Area {

    private AreaType type;
    private Coordinates topLeftCornerCoords;
    public static final int areaSize = 80;

    /**
     * Constructor with parameters
     */
    public Area(AreaType type, Coordinates coords) {
        this.type = type;
        this.topLeftCornerCoords = new Coordinates(coords);
    }

    /**
     * Accessor to type
     * @return
     */
    public AreaType getAreaType() {
        return type;
    }

    public void setAreaType(AreaType type) {
        this.type=type;
    }

    public Coordinates getCoords() {
        return topLeftCornerCoords;
    }

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