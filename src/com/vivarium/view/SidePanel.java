package com.vivarium.view;

import com.vivarium.controller.SidePanelActionListener;
import com.vivarium.controller.VivariumController;

import javax.swing.*;

public class SidePanel extends JPanel{

    String[] organismStrings = {"Bear","Blowfish","Bouquetin","Cactus","Camel","Cow","Dog","Dragon","Eagle","Fish","FreshwaterFish","Grass","Mushroom","Rabbit","Tree","Trex","Wolf"};
    private SidePanelActionListener listener;

    public SidePanel(VivariumController vc) {
        super();
        listener = new SidePanelActionListener(this, vc);

        /* Create ComboBox to select organism to spawn */
        JComboBox organismList = new JComboBox(organismStrings);
        organismList.setSelectedIndex(0);
        organismList.setActionCommand("Choice");
        organismList.addActionListener(listener);
        add(organismList);

        /* Create spawn button */
        JButton spawnButton = new JButton("Spawn");
        spawnButton.setVerticalTextPosition(AbstractButton.CENTER);
        spawnButton.setHorizontalTextPosition(AbstractButton.CENTER);
        spawnButton.setActionCommand("Spawn");
        spawnButton.addActionListener(listener);
        add(spawnButton);
    }

}
