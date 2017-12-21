package com.vivarium.model;

public enum AreaType {
    Desert,
    Plain,
    Water,
    Mountain;

    /**
     * Return a random AreaType, used for terrain generation
     * @see Terrain#generateAreas()
     * @return a random AreaType, using Math.random()
     */
    public static AreaType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}