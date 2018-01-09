package com.vivarium.view;

import com.vivarium.model.Organism;
import com.vivarium.model.Vegetal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OrganismView {

    private BufferedImage icon; // An image used in-game to display the organism
    private final int iconSize = 50; // Might be dynamic later
    private Organism organism; // The organism the view will display

    /**
     * Constructor, calls #assignIcon()
     * @param organism the organism to create the view of
     * @see #assignIcon()
     */
    public OrganismView(Organism organism) {
        this.organism = organism;
        assignIcon();
    }

    /**
     * Assign an icon to the OrganismView, this icon is used in-game to display the organism
     * Every organism's icon is stored in resources/organisms/
     */
    private void assignIcon() {
        try {
            //InputStream
            //icon = ImageIO.read(getClass().getResourceAsStream("/organisms/"+organism.getClass().getSimpleName()+".png"));
            icon = ImageIO.read(new File("resources/organisms/"+organism.getClass().getSimpleName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simply display the organism in-game
     * @param g the Graphics object, used to draw in the panel
     */
    public void draw(Graphics g) {
        if (organism instanceof Vegetal){
            if (((Vegetal) organism).getEdible()){
                g.drawImage(icon,(int)this.organism.getPos().getX()-iconSize/2,(int)this.organism.getPos().getY()-iconSize/2,iconSize, iconSize,null);
            }
        }
        else{
            g.drawImage(icon,(int)this.organism.getPos().getX()-iconSize/2,(int)this.organism.getPos().getY()-iconSize/2,iconSize, iconSize,null);
        }

    }

    /**
     * A simple getter for the organism
     * @return the organism used by the OrganismView
     */
    public Organism getOrganism() {
        return organism;
    }
}
