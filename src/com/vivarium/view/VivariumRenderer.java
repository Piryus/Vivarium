package com.vivarium.view;

import com.vivarium.model.Vivarium;

import java.awt.*;

public class VivariumRenderer implements Renderer {

    private Vivarium vivarium;
    private TerrainView terrainView;

    public VivariumRenderer(Vivarium vivarium) {
        this.vivarium = vivarium;
        this.terrainView = new TerrainView(vivarium.getTerrain());
    }

    @Override
    public void render(Graphics g) {
        /* Render terrain */
        this.terrainView.draw(g);
        /* TODO Render organisms */
    }
}
