package com.vivarium.view;

import com.vivarium.model.Area;
import com.vivarium.model.AreaType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AreaView {

    private BufferedImage texture; // The area's texture displayed in game (sand, grass, rocks, ...)
    private Area area; // The Area represented by the AreaView

    /**
     * Constructor, calls #assignTexture
     * @param area the Area to display
     * @see #assignTexture(AreaType)
     */
    public AreaView(Area area) {
        this.area = area;
        assignTexture(this.area.getAreaType());
    }

    /**
     * Draw the area's texture to its coordinates
     * @param g
     */
    public void draw(Graphics g) {
        g.drawImage(this.texture, (int)area.getCoords().getX(), (int)this.area.getCoords().getY(), null);
    }

    /**
     * Assign a texture to an area depending on its type
     * @param type the area's type (desert, plains, mountain, ...), used to determine which texture to use
     */
    private void assignTexture(AreaType type) {
        try {
            texture = ImageIO.read(new File("resources/areas/"+area.getAreaType().toString()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
