package com.vivarium.view;

import com.vivarium.controller.VivariumController;
import com.vivarium.model.Organism;
import com.vivarium.model.Vivarium;

import java.awt.*;
import java.util.ArrayList;

public class VivariumRenderer implements Renderer {

    private VivariumController vivarium;
    private TerrainView terrainView;
    private ArrayList<OrganismView> organismView = new ArrayList<>();

    public VivariumRenderer(VivariumController vivarium) {
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
        for (Organism o : vivarium.getNewOrganisms()){
            organismView.add(new OrganismView(o));
        }
        /* TODO : retirer les vieux organismes de organismView
        for (Organism o : vivarium.getOldOrganisms()){

        }*/
        vivarium.clearOldNew();
        for(int i=0;i<this.organismView.size();i++) {
            organismView.get(i).draw(g);
        }
    }
}
