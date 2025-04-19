/**
 * This is the graphicalInterface package.
 * */
package graphicalInterface;
/**File name:DrumPanel.java
@author: Smriti Kohli , 041156272
Course : CST8132 - OOP
Assignment : Assignment 002
Date : March 16th, 2025
Professor: Amal Ibrahim 
Purpose :This class serves as the main panel/container object for the application GUI widgets. 
Class List : Drum.java, FlammableDrum.java, ToxicDrum.java, Drum_Test.java, DrumPanel.java
*/

/**
* @author: Smriti Kohli
* @version: openjdk 21.0.4 2024-07-16 LTS
* @see: graphicalInterface>object
* @since: javac 21.0.4
*/


import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import domain.Drum;
import domain.FlammableDrum;
import domain.ToxicDrum;

/**
 * This class is the main panel/container object for the application GUI widgets.
 */
public class DrumPanel extends JPanel {
	/**
	 * This is the label used to enter drum-related information by the user.
	 * */
    private JLabel drumPrompt;
    /**
	 * This is the text field where user enters the count of drums to create.
	 * */
    private JTextField numberToCreate;
    /**
	 * This is the radio button to select the flammableDrumType.
	 * */
    private JRadioButton flammableDrumType;
    /**
	 * This is the radio button to select the toxicDrumType.
	 * */
    private JRadioButton toxicDrumType;
    /**
	 * This is the button to trigger the creation of the drums based on user input.
	 * */
    private JButton createDrums;
    /**
	 * This is the button to execute the tests on the created drums.
	 * */
    private JButton runTests;
    /**
	 * This is the text area use to display the results.
	 * */
    private JTextArea testResults;
    /**
	 * This is the label to show the current status to the user.
	 * */
    private JLabel statusField;

    /**
	 * List of drums created.
	 * */
    List<Drum> listOfDrums = new ArrayList<>();

    /**
     * Serial version required. 
     * */
    private static final long serialVersionUID = 1L;

    /**
	 * Create and populate the main drum panel with appropriate GUI widgets.
	 */
    public DrumPanel() {
        initGUI();
    }

    /**
	 * Create and populate the panel with appropriate GUI components.
	 */
    private void initGUI() {
        setToolTipText("When finished with the application click the 'X' on the top bar, right side to close the application");
        setLayout(new FlowLayout());

        JPanel p = new JPanel();
        p.add(createDrumTypePanel());
        p.add(createDrumNumberPanel());
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(p);
        box.add(createButtonPanel());

        add(box, TOP_ALIGNMENT);
        add(createResultsPanel(), CENTER_ALIGNMENT);
        statusField = new JLabel("Status field for errors etc.");
        add(statusField, BOTTOM_ALIGNMENT);
    }

    /**
	 * Creates a panel containing a scrollable text area for displaying results.
	 * 
	 * @return trp
	 */
    private JPanel createResultsPanel() {
        JPanel trp = new JPanel();
        testResults = new JTextArea(25, 50);
        testResults.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Results"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        testResults.setBorder(BorderFactory.createRaisedBevelBorder());
        JScrollPane sp = new JScrollPane(testResults);
        trp.add(sp);
        return trp;
    }

    /**
	 * Create the drum number panel.
	 * 
	 * @return numberPanel
	 */
    private JPanel createDrumNumberPanel() {
        drumPrompt = new JLabel("Number of drums to create ");
        drumPrompt.setToolTipText("The number of drums to create");
        numberToCreate = new JTextField(10);
        numberToCreate.setToolTipText("Enter the number of drums to create");

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
        numberPanel.add(drumPrompt);
        numberPanel.add(numberToCreate);
        numberPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        return numberPanel;
    }

    /**
	 * Create the drum button panel.
	 * 
	 * @return	The panel object containing the buttons.
	 */
    private JPanel createButtonPanel() {
        createDrums = new JButton("Create Drums");
        createDrums.setToolTipText("Click me to create the specified number and type of drums to create");
        /**
         * Add an eventListener to the Create Drums button.
         * */
        createDrums.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    int numberOfDrums = Integer.parseInt(numberToCreate.getText());
                    if (flammableDrumType.isSelected()) {
                        testResults.append("Creating [" + numberOfDrums + "] Flammable Drums\n");
                        for (int i = 0; i < numberOfDrums; i++) {
                            FlammableDrum drum = new FlammableDrum(36.0f, 24.0f, "Flammable Contents", 100.0f);
                            listOfDrums.add(drum);
                        }
                    } else if (toxicDrumType.isSelected()) {
                        testResults.append("Creating [" + numberOfDrums + "] Toxic Drums\n");
                        for (int i = 0; i < numberOfDrums; i++) {
                            ToxicDrum drum = new ToxicDrum(36.0f, 24.0f, "Radioactive Isotopes", ToxicDrum.CLASS_III);
                            listOfDrums.add(drum);
                        }
                    } else {
                        statusField.setText("NO Drum type has been selected");
                    }
                } catch (NumberFormatException e) {
                    statusField.setText("Invalid number of drums.");
                }
            }
        });

        /**
         * Creates the Run Test button. 
         * */
        runTests = new JButton("Run Tests");
        runTests.addActionListener(new ActionListener() {
        	/**
        	 * Adds an eventListener for the Run Test button.
        	 * */
            public void actionPerformed(ActionEvent ae) {
                statusField.setText("Running tests...");
                testResults.append("\n");
                int count = 1;
                for (Drum drum : listOfDrums) {
                    testResults.append("[" + count + "]: " + drum.toString() + "\n");
                    count++;
                }
                statusField.setText(" ***Testing Drum Value Display*** ");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        buttonPanel.add(createDrums);
        buttonPanel.add(runTests);
        
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Action"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        return buttonPanel;
    }

    /**
	 * Create the drum creation panel.
	 * 
	 * @return typePanel
	 */
	private JPanel createDrumTypePanel() {
		flammableDrumType = new JRadioButton("Flammable Drum");
		toxicDrumType = new JRadioButton("Toxic Drum");
		ButtonGroup group = new ButtonGroup();
		group.add(toxicDrumType);
		group.add(flammableDrumType);
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.add(flammableDrumType);
		typePanel.add(toxicDrumType);
		typePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Types of Drums"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		typePanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return typePanel;
	}

}
