package com.vivarium.view;

import com.vivarium.model.Terrain;

import javax.swing.*;
import java.awt.*;

import static com.vivarium.view.TerrainView.drawTerrain;

public class GamePanel extends JPanel {
    private Terrain terr=new Terrain();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTerrain(g, terr);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(2000,2000);
    }
}
