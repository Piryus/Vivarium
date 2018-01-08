package com.vivarium.controller;

import com.vivarium.model.Sex;
import com.vivarium.model.*;
import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class SidePanelActionListener implements ActionListener {

    private SidePanel sidePanel;
    private VivariumController vc;
    private String AnimalNameComboBox = "Bear";
    private String VegetalNameComboBox = "Aubergine";
    private Sex AnimalSexComboBox = Sex.Male;

    public SidePanelActionListener(SidePanel sidePanel, VivariumController vc)
    {
        this.sidePanel=sidePanel;
        this.vc = vc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // If the user changes the animal in the side panel's appropriate combo box, gets the animal name
        if("Choice".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            AnimalNameComboBox = (String)cb.getSelectedItem();
        }

        // If the user changes the vegetal in the side panel's appropriate combo box, gets the vegetal name
        if("VegetalChoice".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            VegetalNameComboBox = (String)cb.getSelectedItem();
        }

        // If the user changes the animal's sex in the side panel's appropriate combo box, gets the sex
        if("Sex".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            if("Male".equals(cb.getSelectedItem())) {
                AnimalSexComboBox = Sex.Male;
            }
            else AnimalSexComboBox = Sex.Female;
        }

        // If the user clicks on the animal spawn button
        if("Spawn".equals(e.getActionCommand())) {
            // We create a new instance of an animal class from an animal's string
            try {
                // Gets the class name from the string selected in the animal's combo box
                Class organism = Class.forName("com.vivarium.model."+AnimalNameComboBox);
                // Gets the constructor for this class
                Constructor constructor = organism.getConstructor(int.class,int.class,Vivarium.class,Sex.class);
                // And finally creates a new instance of the animal
                Organism o = (Organism)constructor.newInstance(new Object[]{sidePanel.getSpawnPosX(),sidePanel.getSpawnPosY(),vc.getVivarium(), AnimalSexComboBox});
                String newName = sidePanel.getNewName();
                if (!newName.equals(""))
                    o.setName(newName);
                sidePanel.setFocus(o);
                vc.add(o);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }
        }

        // If the user clicks on the vegetal spawn button
        if("SpawnVegetal".equals(e.getActionCommand())) {
            try {
                Class vegetal = Class.forName("com.vivarium.model."+VegetalNameComboBox);
                Constructor constructor = vegetal.getConstructor(int.class,int.class,Vivarium.class);
                Organism o = (Organism)constructor.newInstance(new Object[]{sidePanel.getSpawnPosX(),sidePanel.getSpawnPosY(),vc.getVivarium()});
                sidePanel.setFocus(o);
                vc.add(o);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }
        }

        // If the user clicks on the kill button
        if ("Kill".equals(e.getActionCommand())){
            // Checks whether the focus is on an organism or not
            if (sidePanel.getFocus() != null){
                // If it is, delete this animal from the vivarium
                vc.delete(sidePanel.getFocus());
            }
        }

        if ("StatNameUpdate".equals(e.getActionCommand())){
            sidePanel.getFocus().setName(sidePanel.getFocusName());
        }

    }
}
