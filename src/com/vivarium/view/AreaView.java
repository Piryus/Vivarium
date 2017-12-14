package com.vivarium.view;

import com.vivarium.model.Area;
import com.vivarium.model.AreaType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AreaView {

    private BufferedImage texture; // TODO Load 4 images for the whole terrain
    private Area area;

    public AreaView(Area area) {
        this.area = area;
        assignTexture(this.area.getAreaType());
    }

    public void draw(Graphics g) {
        g.drawImage(this.texture, (int)area.getCoords().getX(), (int)this.area.getCoords().getY(), null);
    }

    /**
     * Assign texture to this (Area)
     */
    private void assignTexture(AreaType type) {
        try {
            texture = ImageIO.read(new File("resources/areas/"+area.getAreaType().toString()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
