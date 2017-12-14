package com.vivarium;

import com.vivarium.model.*;
import com.vivarium.view.GamePanel;
import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.*;
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
            Area randomAreaDesert = vivarium.getTerrain().getRandomAreaOfType(AreaType.Desert);
            vivarium.add(new Cactus((int)randomAreaDesert.getCoords().getX()+40,(int)randomAreaDesert.getCoords().getY()+40, vivarium));
        }

        for (int i=0; i < 40; i++) {
            Area randomArea = vivarium.getTerrain().getRandomAreaOfType(AreaType.Plain);
            vivarium.add(new Grass((int)randomArea.getCoords().getX()+40,(int)randomArea.getCoords().getY()+40,vivarium));
        }


        GamePanel gp = new GamePanel(vivarium);
        SidePanel sidePanel = new SidePanel();
        JScrollPane sp = new JScrollPane(gp,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.add(sp, BorderLayout.CENTER);
        window.add(sidePanel,BorderLayout.EAST);
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
