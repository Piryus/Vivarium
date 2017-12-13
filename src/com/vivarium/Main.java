package com.vivarium;

import com.vivarium.model.*;
import com.vivarium.view.GamePanel;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Vivarium");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setLocationRelativeTo(null);
        Vivarium vivarium = new Vivarium();

        Random ran = new Random();

        for (int i = 0; i < 500; i++){
            vivarium.add(new Wolf(ran.nextInt(vivarium.getTerrain().getWidth()),ran.nextInt(vivarium.getTerrain().getHeight()), vivarium, Sex.Female));
            vivarium.add(new Wolf(ran.nextInt(vivarium.getTerrain().getWidth()),ran.nextInt(vivarium.getTerrain().getHeight()), vivarium, Sex.Male));
        }

        for (int i = 0; i < 20; i++){
            vivarium.add(new Aubergine(ran.nextInt(vivarium.getTerrain().getWidth()),ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
            vivarium.add(new Cactus(ran.nextInt(vivarium.getTerrain().getWidth()),ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
        }


        GamePanel gp = new GamePanel(vivarium);
        JScrollPane sp = new JScrollPane(gp,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.setContentPane(sp);
        window.pack();
        window.setVisible(true);
        while (true){
            vivarium.loop();
            window.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
