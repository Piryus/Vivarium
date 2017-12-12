package com.vivarium.model;


import com.vivarium.view.AreaView;

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

    public Coordinates getCoords() {
        return coords;
    }
}