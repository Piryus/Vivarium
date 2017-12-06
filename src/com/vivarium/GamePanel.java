package com.vivarium;

import javax.swing.*;
import java.awt.*;

import static com.vivarium.TerrainView.drawTerrain;

public class GamePanel extends JPanel {
    private Terrain terr=new Terrain();
    public void paintComponent(Graphics g) {
        drawTerrain(g, terr);
    }

}
