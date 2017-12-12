package com.vivarium.controller;

import com.vivarium.model.Vivarium;

import java.awt.*;

public class GameEngine {
    private Vivarium vivarium;
    public GameEngine() {
        vivarium = new Vivarium();
    }
    public boolean handleEvent(Event e) {
        switch(e.id) {
            //Handle event types
        }
        return false;
    }

    public void update(float dt) {
        //empty
    }

    public void render(Graphics g) {
        //empty
    }
}
