package com.vivarium;

import java.util.*;


public class Area {
    private AreaType type;
    private AreaView view;
    private ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
    /**
     * Default constructor
     */
    public Area() {}

    /**
     * Constructor with parameters
     */
    public Area(AreaType type, Coordinates[] coords) {
        this.type = type;
        this.view = new AreaView(type);
        for(int i=0;i < coords.length; i++) {
            this.coords.add(new Coordinates(coords[i]));
        }
    }

    /**
     * Accessor to type
     * @return
     */
    public AreaType getAreaType() {
        return type;
    }

    public AreaView getAreaView() {
        return view;
    }

    public ArrayList<Coordinates> getCoords() {
        return coords;
    }
}