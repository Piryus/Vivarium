package com.vivarium.view;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        this.setTitle("Vivarium");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        GamePanel gamePanel = new GamePanel();
        this.setContentPane(gamePanel);
        this.setVisible(true);
    }
}
