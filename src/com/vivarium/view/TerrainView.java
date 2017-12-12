package com.vivarium.view;

import com.vivarium.model.Terrain;

import java.awt.*;
import java.util.ArrayList;


public class TerrainView {

    private Terrain terrain;
    private ArrayList<AreaView> areaView = new ArrayList<AreaView>();

    public TerrainView(Terrain terrain) {
        this.terrain = terrain;
        for(int i=0;i<this.terrain.getAreasList().size();i++) {
            this.areaView.add(new AreaView(this.terrain.getAreasList().get(i)));
        }
    }

    public void draw(Graphics g) {
        for(int i=0;i<this.terrain.getAreasList().size();i++)
        {
            this.areaView.get(i).draw(g);
        }
    }
}
