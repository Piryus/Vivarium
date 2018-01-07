package com.vivarium;

import com.vivarium.controller.VivariumController;
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
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Vivarium vivarium = new Vivarium();
        VivariumController vc = new VivariumController(vivarium);
        Random ran = new Random();

        SidePanel sidePanel = new SidePanel(vc);
        GamePanel gp = new GamePanel(vc, sidePanel);

        JScrollPane sp = new JScrollPane(gp,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.add(sp, BorderLayout.CENTER);
        window.add(sidePanel,BorderLayout.EAST);
        window.pack();
        window.setVisible(true);

        for (int i = 0; i < 5; i++){
            vc.add(new Camel(ran.nextInt(vc.getTerrain().getWidth()),ran.nextInt(vc.getTerrain().getHeight()), vivarium, Sex.Female));
            vc.add(new Camel(ran.nextInt(vc.getTerrain().getWidth()),ran.nextInt(vc.getTerrain().getHeight()), vivarium, Sex.Male));
        }

        for (int i = 0; i < 20; i++){
            vc.add(new Aubergine(ran.nextInt(vivarium.getTerrain().getWidth()),ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
            Area randomAreaDesert = vivarium.getTerrain().getRandomAreaOfType(AreaType.Desert);
            vc.add(new Cactus((int)randomAreaDesert.getCoords().getX()+40,(int)randomAreaDesert.getCoords().getY()+40, vivarium));
        }

        for (int i=0; i < 40; i++) {

           vc.add(new Bouquetin(ran.nextInt(vc.getTerrain().getWidth()),ran.nextInt(vc.getTerrain().getHeight()), vivarium, Sex.Male));
        }


        while (true){
            vc.loop();
            window.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
