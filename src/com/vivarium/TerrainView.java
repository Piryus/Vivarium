package com.vivarium;

import java.awt.*;

import static com.vivarium.AreaView.drawArea;

public class TerrainView {
    public TerrainView(Graphics g, Terrain terrain) {
        drawTerrain(g, terrain);
    }

    public static void drawTerrain(Graphics g, Terrain terrain) {
        for(int i=0;i<terrain.getAreasList().size();i++)
        {
            drawArea(g,terrain.getAreasList().get(i));
        }
    }
}
