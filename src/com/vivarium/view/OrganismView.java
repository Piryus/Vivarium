package com.vivarium.view;

import com.vivarium.model.Organism;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OrganismView {

    private BufferedImage icon; // TODO Load only one images for each organism
    private final int iconSize = 50;
    private Organism organism;

    public OrganismView(Organism organism) {
        this.organism = organism;
        assignIcon();
    }

    private void assignIcon() {
        try {
            icon = ImageIO.read(new File("resources/organisms/"+organism.getClass().getSimpleName()+".png")); // TODO Sex type
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(icon,(int)this.organism.getPos().getX()-iconSize/2,(int)this.organism.getPos().getY()-iconSize/2,iconSize, iconSize,null);
    }

    public Organism getOrganism() {
        return organism;
    }
}
