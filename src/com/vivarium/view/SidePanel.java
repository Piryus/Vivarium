package com.vivarium.view;

import com.vivarium.controller.SidePanelActionListener;

import javax.swing.*;

public class SidePanel extends JPanel{

    private JButton wolfButton;
    private SidePanelActionListener listener = new SidePanelActionListener(this);

    public SidePanel() {
        super();
        wolfButton = new JButton("Spawn wolf (TEST)");
        wolfButton.setVerticalTextPosition(AbstractButton.CENTER);
        wolfButton.setHorizontalTextPosition(AbstractButton.CENTER);
        wolfButton.addActionListener(listener);
        add(wolfButton);
    }

}
