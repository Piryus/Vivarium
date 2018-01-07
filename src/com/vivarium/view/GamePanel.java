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

public class GamePanel extends JPanel{

    private VivariumRenderer vivariumRenderer;
    private SidePanel sp;

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
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        vivariumRenderer.render(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(5000,5000); // TODO dynamic
    }

}
