package com.vivarium.view;

import com.vivarium.model.Organism;
import com.vivarium.model.Vivarium;

import java.awt.*;
import java.util.ArrayList;

public class VivariumRenderer implements Renderer {

    private Vivarium vivarium;
    private TerrainView terrainView;
    private ArrayList<OrganismView> organismView = new ArrayList<>();

    public VivariumRenderer(Vivarium vivarium) {
        this.vivarium = vivarium;
        this.terrainView = new TerrainView(vivarium.getTerrain());
        for (int i=0; i<this.vivarium.getOrganisms().size(); i++) {
            this.organismView.add(new OrganismView(this.vivarium.getOrganisms().get(i)));
        }
    }

    @Override
    public void render(Graphics g) {
        /* Render terrain */
        this.terrainView.draw(g);
        for(int i=0;i<this.organismView.size();i++) {
            organismView.get(i).draw(g);
        }
    }
}
