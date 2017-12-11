package com.vivarium.view;

import com.vivarium.model.Terrain;

import java.awt.*;

import static com.vivarium.view.AreaView.drawArea;

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
