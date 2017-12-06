package com.vivarium;

import java.util.*;


public class Area {
    private AreaType type;
    private AreaView view;
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
        this.view = new AreaView(type);
        this.coords = new Coordinates(coords);

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

    public Coordinates getCoords() {
        return coords;
    }
}