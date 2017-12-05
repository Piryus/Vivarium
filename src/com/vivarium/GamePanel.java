package com.vivarium;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.vivarium.AreaView.drawArea;

public class GamePanel extends JPanel {
    //private int doggoPosX; //For testing purpose only /!\
    //private int doggoPosY; //For testing purpose only /!\

    public void paintComponent(Graphics g) {
        Coordinates coord[]=new Coordinates[3];
        Coordinates coord1[]=new Coordinates[3];
        Coordinates coord2[]=new Coordinates[1];
        coord[0]=new Coordinates(0,0);
        coord[1]=new Coordinates(0,80);
        coord[2]=new Coordinates(80,0);
        coord1[0]=new Coordinates(160,0);
        coord1[1]=new Coordinates(160,80);
        coord1[2]=new Coordinates(160,160);
        coord2[0]=new Coordinates(160,240);
        Area testDesert = new Area(AreaType.Desert,coord);
        drawArea(g,testDesert);
        Area testPlain = new Area(AreaType.Plain,coord1);
        drawArea(g,testPlain);
        Area testWater = new Area(AreaType.Water,coord2);
        drawArea(g,testWater);
        /*try {
            Image dog = ImageIO.read(new File("resources/dog.png"));
            doggoPosX++;
            doggoPosY++;
            g.drawImage(dog, doggoPosX, doggoPosY, 50,50, this);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
