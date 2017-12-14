package com.vivarium.controller;

import com.vivarium.model.Sex;
import com.vivarium.model.Wolf;
import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanelActionListener implements ActionListener {

    private SidePanel sidePanel;
    private VivariumController vc;

    public SidePanelActionListener(SidePanel sidePanel, VivariumController vc)
    {
        this.sidePanel=sidePanel;
        this.vc = vc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized(vc) {
            vc.add(new Wolf(100, 100, vc.getVivarium(), Sex.Male));
            System.out.println("UN LOUP SAUVAGE APPARAIT");
        }
    }
}
