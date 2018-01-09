package com.vivarium.view;

import com.vivarium.controller.VivariumController;
import com.vivarium.model.Organism;

import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * GamePanel class is essential to the game, it is the window's area in which the terrain and the organisms are displayed
 */
public class GamePanel extends JPanel{

    private VivariumRenderer vivariumRenderer;
    private SidePanel sp;

    /**
     * The GamePanel constructor
     * @param vivarium
     * @param sp the sidePanel, necessary to display organisms' stats
     */
    public GamePanel(VivariumController vivarium, SidePanel sp) {
        vivariumRenderer = new VivariumRenderer(vivarium);
        this.sp = sp;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Organism o = vivarium.getOrganismAtPos(e.getX(), e.getY());
                if (o != null)
                    sp.setFocus(o);
                sp.setSpawnPos(e.getX(),e.getY());
            }
        });
    }

    /**
     * Calls the vivarium renderer to display the terrain and the organisms
     * @param g the Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        vivariumRenderer.render(g);
    }

    /**
     * A simple but very important function that returns the desired size of the GamePanel, thus the terrain's size
     * @return a Dimension object, containing gamePanel's width and height
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(3000,3000);
    }

}
