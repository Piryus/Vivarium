package com.vivarium.view;

import com.vivarium.controller.SidePanelActionListener;
import com.vivarium.controller.VivariumController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel{

    private SidePanelActionListener listener;
    private VivariumController vc;

    public SidePanel(VivariumController vc) {
        super();
        this.vc = vc;

        //setLayout(new GridLayout(2,1));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Create Listener for ActionEvents
        listener = new SidePanelActionListener(this, vc);

        createSpawnAnimalPanel();
        createSpawnVegetalPanel();
    }

    /**
     * Create SpawnAnimalPanel inside the SidePanel
     * This panel allows the user to spawn a desired animal with multiple options
     */
    private void createSpawnAnimalPanel() {
        // Create spawnAnimalPanel general settings
        JPanel spawnPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spawnPanel.setBorder(BorderFactory.createTitledBorder("Spawn an animal"));
        add(spawnPanel);

        // Create default insets
        Insets defaultInsets = new Insets(5,0,0,0);

        // Create ComboBox to select organism to spawn
        String[] animalStrings = {"Bear","Blowfish","Bouquetin","Camel","Cow","Dog","Dragon","Eagle","Fish","FreshwaterFish","Rabbit","Trex","Wolf"};
        createComboBox(spawnPanel,animalStrings,gbc,"Choice",listener,new Insets(5,0,0,5),0,0,1,1);

        // Create ComboBox to select sex
        String[] animalSexStrings = {"Male","Female"};
        createComboBox(spawnPanel,animalSexStrings, gbc,"Sex",listener,defaultInsets,1,0,1,1);

        // Create text field for organism's name
        createLabel(spawnPanel,"Name :",JLabel.CENTER,gbc,defaultInsets,0,1,1,1);
        createTextField(spawnPanel,15,gbc,"NameUpdate",listener,defaultInsets,1,1,1,1);

        // Create spawn button
        createButton(spawnPanel,"Spawn",gbc,"Spawn",listener,defaultInsets,0,2,2,1);

    }

    private void createSpawnVegetalPanel() {
        JPanel spawnVegetalPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spawnVegetalPanel.setBorder(BorderFactory.createTitledBorder("Spawn a vegetal"));
        add(spawnVegetalPanel);
    }

    /**
     * Generic method to create a button
     * @param panel the panel in which the button will be placed
     * @param text the button's text
     * @param gbc the GridBagConstraints used
     * @param actionCommand the ActionCommand used by the listener
     * @param listener the listener that will execute the button's action
     * @param insets if null, new Insets(0,0,0,0) are created
     * @param gridx x position on the grid
     * @param gridy y position on the grid
     * @param gridwidth the number of horizontal cell that the button should occupy
     * @param gridheight the number of vertical cell that the button should occupy
     */

    private static void createButton(JPanel panel, String text, GridBagConstraints gbc, String actionCommand, ActionListener listener, Insets insets, int gridx, int gridy, int gridwidth, int gridheight)
    {
        JButton button = new JButton(text);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        if(insets==null){
            gbc.insets = new Insets(0,0,0,0);
        }
        else
        {
            gbc.insets = insets;
        }
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.gridx = gridx;
        gbc.gridy= gridy;
        panel.add(button,gbc);
    }

    /**
     * Generic method to create a TextField
     * @see #createButton for params
     * @param columns the number of char that should fit in the field
     */
    private static void createTextField(JPanel panel, int columns, GridBagConstraints gbc, String actionCommand, ActionListener listener, Insets insets, int gridx, int gridy, int gridwidth, int gridheight) {
        JTextField textField = new JTextField(columns);
        textField.addActionListener(listener);
        textField.setActionCommand(actionCommand);
        if(insets==null){
            gbc.insets = new Insets(0,0,0,0);
        }
        else
        {
            gbc.insets = insets;
        }
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        panel.add(textField,gbc);
    }

    /**
     * Generic method to create a label
     * @see #createButton for params
     * @param text the label text
     * @param horizontalAlignement how should the text behave (centered horizontally, etc)
     */
    private static void createLabel(JPanel panel, String text, int horizontalAlignement, GridBagConstraints gbc, Insets insets, int gridx, int gridy, int gridwidth, int gridheight) {
        JLabel label = new JLabel(text, horizontalAlignement);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        if(insets==null) {
            gbc.insets = new Insets(0,0,0,0);
        }
        else {
            gbc.insets = insets;
        }
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        panel.add(label,gbc);
    }

    /**
     * Generic method to create a ComboBox
     * @see #createButton for params
     * @param strings the choices available in the ComboBox
     */
    private static void createComboBox(JPanel panel, String[] strings, GridBagConstraints gbc, String actionCommand, ActionListener listener, Insets insets, int gridx, int gridy, int gridwidth, int gridheight)
    {
        JComboBox comboBox = new JComboBox(strings);
        comboBox.setSelectedIndex(0);
        comboBox.setActionCommand(actionCommand);
        comboBox.addActionListener(listener);
        if(insets==null){
            gbc.insets = new Insets(0,0,0,0);
        }
        else
        {
            gbc.insets = insets;
        }
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.gridx = gridx;
        gbc.gridy= gridy;
        panel.add(comboBox,gbc);
    }

}
