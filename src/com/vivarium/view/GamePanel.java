package com.vivarium.view;

import com.vivarium.controller.VivariumController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private VivariumRenderer vivariumRenderer;

    public GamePanel(VivariumController vivarium) {
        vivariumRenderer = new VivariumRenderer(vivarium);
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
