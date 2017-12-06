package com.vivarium.view;

import com.vivarium.model.Terrain;

import javax.swing.*;
import java.awt.*;

import static com.vivarium.view.TerrainView.drawTerrain;

public class GamePanel extends JPanel {
    private Terrain terr=new Terrain();
    public void paintComponent(Graphics g) {
        drawTerrain(g, terr);

    }

}
