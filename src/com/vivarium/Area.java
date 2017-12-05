package com.vivarium;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Area {
    private AreaType type;
    private AreaView view;
    private Coordinates coords;
    /**
     * Default constructor
     */
    public Area() {}

    /**
     * Constructor with parameters
     */
    public Area(AreaType type) {
        this.type = type;
        this.view = new AreaView(type);
    }

    /**
     * Accessor to type
     * @return
     */
    public AreaType getAreaType() {
        return type;
    }
}