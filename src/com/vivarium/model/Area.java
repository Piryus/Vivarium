package com.vivarium.model;


import com.vivarium.view.AreaView;

import java.util.ArrayList;

public class Area {
    private AreaType type;
    private Coordinates coords = new Coordinates();
    /**
     * Default constructor
     */
    public Area() {}

    /**
     * Constructor with parameters
     */
    public Area(AreaType type, Coordinates coords) {
        this.type = type;
        this.coords = new Coordinates(coords);

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
        return coords;
    }

    public ArrayList<Area> getSurroundingAreas(ArrayList<Area> areaList) {
        ArrayList<Area> surroundingAreasList = new ArrayList<>();
        for(int i=0;i<areaList.size();i++) {
            if ((((areaList.get(i).getCoords().getX() == this.getCoords().getX() - 80) ||
                            (areaList.get(i).getCoords().getX() == this.getCoords().getX() + 80)) && (areaList.get(i).getCoords().getY() == this.getCoords().getY())) ||
                            (((areaList.get(i).getCoords().getY() == this.getCoords().getY() - 80) ||
                                    (areaList.get(i).getCoords().getY() == this.getCoords().getY() + 80)) && (areaList.get(i).getCoords().getX() == this.getCoords().getX()))) {
                surroundingAreasList.add(areaList.get(i));
            }
        }
        return surroundingAreasList;
    }
}