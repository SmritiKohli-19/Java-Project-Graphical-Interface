/**
 * This is the test package.
 * */
package test;
/**File name: Drum_Test.java
@author: Smriti Kohli , 041156272
Course : CST8132 - OOP
Assignment : Assignment 002
Date : March 16th, 2025
Professor: Amal Ibrahim 
Purpose :This is a class which tests types of drums.
Class List : Drum.java, FlammableDrum.java, ToxicDrum.java, Drum_Test.java, DrumPanel.java
*/

/**
* @author: Smriti Kohli
* @version: openjdk 21.0.4 2024-07-16 LTS
* @see: test>object
* @since: javac 21.0.4
*/
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import java.awt.Container;
import java.awt.Dimension;

import graphicalInterface.DrumPanel;

/**
 * Test various types of drums and our Graphical Framework.
 */
public class Drum_Test		{

	/**
	 * Main entry point/launcher for this GUI Application test.
	 * @param args	Command line argument list (not used)
	 */
	public static void main(String[] args) {
		initLookAndFeel();

		/*	Schedule a job for the event dispatch thread:
		 * creating and showing this application's GUI.
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(new DrumPanel());
			}
		});

    }
	
	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI(JPanel mainPanel) {
		/* Create and set up the window. */
		JFrame frame = new JFrame("Drum Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 350);
		frame.setPreferredSize(new Dimension(575, 600));
		frame.setMaximumSize(new Dimension(575, 600));
		Container c = frame.getContentPane();
		c.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	
	/**
	 * Set the look and feel for this GUI app.
	 */
	private static void initLookAndFeel() {
		try {
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			UIManager.setLookAndFeel(new MetalLookAndFeel());
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		
		/* Turn off metal's use bold fonts */
//		UIManager.put("swing.boldMetal", Boolean.FALSE);

	
	}

}
