package com.vivarium;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private int doggoPosX; //For testing purpose only /!\
    private int doggoPosY; //For testing purpose only /!\

    public void paintComponent(Graphics g) {
        try {
            Image bg = ImageIO.read(new File("resources/grass.jpg"));
            for(int x=0;x<this.getWidth();x+=bg.getWidth(null))
                for(int y=0;y<this.getHeight();y+=bg.getHeight(null))
                    g.drawImage(bg, x, y, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Image dog = ImageIO.read(new File("resources/dog.png"));
            doggoPosX++;
            doggoPosY++;
            g.drawImage(dog, doggoPosX, doggoPosY, 50,50, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
