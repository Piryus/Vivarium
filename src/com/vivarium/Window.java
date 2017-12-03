package com.vivarium;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        this.setTitle("Vivarium");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,750);
        this.setLocationRelativeTo(null);
        GamePanel gamePanel = new GamePanel();
        this.setContentPane(gamePanel);
        this.setVisible(true);
    }
}
