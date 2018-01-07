package com.vivarium.view;

import com.vivarium.controller.VivariumController;
import com.vivarium.model.Organism;
import com.vivarium.model.Vivarium;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.function.Predicate;

public class VivariumRenderer implements Renderer{

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
        for (Organism o : vivarium.getNewOrganisms()) {
            organismView.add(new OrganismView(o));
        }

        for (Organism o : vivarium.getOldOrganisms()) {
            Predicate<OrganismView> test = new Predicate<OrganismView>() {
                @Override
                public boolean test(OrganismView ov) {
                    return ov.getOrganism().equals(o);
                }
            };
            organismView.removeIf(test);
        }
        vivarium.clearOldNew();
        for (int i = 0; i < this.organismView.size(); i++) {
            organismView.get(i).draw(g);
        }
    }
}
