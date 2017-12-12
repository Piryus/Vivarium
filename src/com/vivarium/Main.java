package com.vivarium;

import com.vivarium.model.Vivarium;
import com.vivarium.view.GamePanel;

import javax.swing.*;

public class Main {

    //private GameEngine engine = new GameEngine();

    public static void main(String[] args) {
        JFrame window = new JFrame("Vivarium");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setLocationRelativeTo(null);
        Vivarium vivarium = new Vivarium();
        GamePanel gp = new GamePanel(vivarium);
        JScrollPane sp = new JScrollPane(gp,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.setContentPane(sp);
        window.pack();
        window.setVisible(true);
        /* while(true) {
        //game loop
        } */
    }
}
