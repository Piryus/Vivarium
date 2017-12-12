package com.vivarium.view;

import com.vivarium.model.Organism;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OrganismView {
    private BufferedImage icon;

    private void assignIcon() {
        try {
            icon = ImageIO.read(new File("resources/organism/"+getClass().toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawAnimal(Graphics g, Organism organism) {
        g.drawImage(icon,organism.getPos().getX(),organism.getPos().getY(),20,20,null);
    }
}
