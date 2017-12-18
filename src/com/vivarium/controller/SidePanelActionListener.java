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
    private String organismNameComboBox = "Bear";
    private Sex organismSexComboBox = Sex.Male;

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

        if("Sex".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            // TODO Less dirty code
            if("Male".equals(cb.getSelectedItem())) {
                organismSexComboBox = Sex.Male;
            }
            else organismSexComboBox = Sex.Female;
        }

        if("Spawn".equals(e.getActionCommand())) {
            try {
                Class organism = Class.forName("com.vivarium.model."+organismNameComboBox);
                Constructor constructor = organism.getConstructor(int.class,int.class,Vivarium.class,Sex.class);
                vc.add((Organism)constructor.newInstance(new Object[]{100,100,vc.getVivarium(),organismSexComboBox}));
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
