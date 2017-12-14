package com.vivarium.controller;

import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanelActionListener implements ActionListener {

    private SidePanel sidePanel;

    public SidePanelActionListener(SidePanel sidePanel) {
        this.sidePanel=sidePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("UN LOUP SAUVAGE APPARAIT"); //TODO
    }
}
