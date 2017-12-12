package com.vivarium.view;

import com.vivarium.model.Organism;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OrganismView {

    private BufferedImage icon; // TODO Load only one images for each organism
    private Organism organism;

    public OrganismView(Organism organism) {
        this.organism = organism;
    }

    private void assignIcon() {
        try {
            icon = ImageIO.read(new File("resources/organism/"+getClass().toString()+".png")); // TODO Sex type
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(icon,this.organism.getPos().getX(),this.organism.getPos().getY(),20,20,null);
    }
}
