package com.vivarium.view;

import com.vivarium.controller.SidePanelActionListener;
import com.vivarium.controller.VivariumController;

import javax.swing.*;

public class SidePanel extends JPanel{

    private JButton wolfButton;
    private SidePanelActionListener listener;

    public SidePanel(VivariumController vc) {
        super();
        listener = new SidePanelActionListener(this, vc);
        wolfButton = new JButton("Spawn wolf (TEST)");
        wolfButton.setVerticalTextPosition(AbstractButton.CENTER);
        wolfButton.setHorizontalTextPosition(AbstractButton.CENTER);
        wolfButton.addActionListener(listener);
        add(wolfButton);
    }

}
