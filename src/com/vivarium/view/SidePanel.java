package com.vivarium.view;

import com.vivarium.controller.SidePanelActionListener;
import com.vivarium.controller.VivariumController;

import javax.swing.*;

public class SidePanel extends JPanel{

    private SidePanelActionListener listener;

    public SidePanel(VivariumController vc) {
        super();

        //Todo Create multiple panels and use holderPanel.setBorder(new EmptyBorder(80, 50, 20, 130)) (https://stackoverflow.com/questions/14550255/jbuttons-inside-jpanels-fill-up-the-whole-panel)
        // Set the layout of the panel and constraints
        /*setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();*/

        // Create Listener for ActionEvents
        listener = new SidePanelActionListener(this, vc);

        // Create ComboBox to select organism to spawn
        JLabel organismListLabel = new JLabel("Organism :",JLabel.LEADING);
        add(organismListLabel);
        String[] animalStrings = {"Bear","Blowfish","Bouquetin","Cactus","Camel","Cow","Dog","Dragon","Eagle","Fish","FreshwaterFish","Grass","Mushroom","Rabbit","Tree","Trex","Wolf"};
        JComboBox organismList = new JComboBox(animalStrings);
        organismList.setSelectedIndex(0);
        organismList.setActionCommand("Choice");
        organismList.addActionListener(listener);
        add(organismList);

        // Create ComboBox to select sex
        String[] animalSex = {"Male","Female"};
        JComboBox animalSexList = new JComboBox(animalSex);
        animalSexList.setSelectedIndex(0);
        animalSexList.setActionCommand("Sex");
        animalSexList.addActionListener(listener);
        add(animalSexList);

        /*// Create text field for organism's name
        JLabel nameTextFieldLabel = new JLabel("Name :",JLabel.LEADING);
        add(nameTextFieldLabel);
        JTextField nameTextField = new JTextField(30);
        nameTextField.addActionListener(listener);
        add(nameTextField);*/

        // Create spawn button
        JButton spawnButton = new JButton("Spawn");
        spawnButton.setVerticalTextPosition(AbstractButton.CENTER);
        spawnButton.setHorizontalTextPosition(AbstractButton.CENTER);
        spawnButton.setActionCommand("Spawn");
        spawnButton.addActionListener(listener);
        add(spawnButton);
    }

}
