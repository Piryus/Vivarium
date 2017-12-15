package com.vivarium.controller;

import com.vivarium.model.Sex;
import com.vivarium.model.*;
import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SidePanelActionListener implements ActionListener {

    private SidePanel sidePanel;
    private VivariumController vc;
    private String organismNameComboBox = null;

    public SidePanelActionListener(SidePanel sidePanel, VivariumController vc)
    {
        this.sidePanel=sidePanel;
        this.vc = vc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Choice".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            organismNameComboBox = (String)cb.getSelectedItem();
        }
        System.out.println(organismNameComboBox);
        if("Spawn".equals(e.getActionCommand())) {
            synchronized(vc) {
                try {
                    Class organism = Class.forName("com.vivarium.model."+organismNameComboBox);
                    Constructor constructor = organism.getConstructor(int.class,int.class,Vivarium.class,Sex.class);
                    vc.add((Organism)constructor.newInstance(new Object[]{100,100,vc.getVivarium(),Sex.Male}));
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
        }
    }
}
