package com.vivarium.model;
/**
 * 
 */
public enum Sex {
    Male,
    Female;

    public static Sex getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}