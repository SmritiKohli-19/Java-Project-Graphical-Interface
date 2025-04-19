package domain;
/**File name:ToxicDrum.java
@author: Smriti Kohli , 041156272
Course : CST8132 - OOP
Assignment : Assignment 002
Date : March 16th, 2025
Professor: Amal Ibrahim 
Purpose :This is a class that extends abstract class Drum and represents a type of drum
that contains toxic materials. 
Class List : Drum.java, FlammableDrum.java, ToxicDrum.java, Drum_Test.java, DrumPanel.java
*/

/**
* @author: Smriti Kohli
* @version: openjdk 21.0.4 2024-07-16 LTS
* @see: domain>object
* @since: javac 21.0.4
*/


/**
 * ToxicDrum class representing a drum that contains toxic materials and extends 
 * abstract class Drum.
 */
public class ToxicDrum extends Drum {
	/**
	 * This is the first variable toxicity which is declared as private with 
	 * data-type String.
	 * */
	private String toxicity;
	/**
	 * This is the second variable CLASS_IA which is declared as public and 
	 * final with data-type String.
	 * */
    public final static String CLASS_IA = "extremely hazardous";
    /**
	 * This is the third variable CLASS_IB which is declared as public and 
	 * final with data-type String.
	 * */
    public final static String CLASS_IB = "highly hazardous";
    /**
	 * This is the fourth variable CLASS_II which is declared as public and 
	 * final with data-type String.
	 * */
    public final static String CLASS_II = "moderately hazardous";
    /**
	 * This is the fifth variable CLASS_III which is declared as public and 
	 * final with data-type String.
	 * */
    public final static String CLASS_III = "slightly hazardous";
    
    /**
     * This is the default non-paramter constructor.
     * */
    public ToxicDrum() {
        super();
        this.toxicity = CLASS_III;
    }

    /**
     * This is the overloaded constructor with height and diameter and toxicity 
     * initialized as CLASS_III
     * @param height: This is the height of the drum.
     * @param diameter:This is the diameter of the drum.
     * */
    public ToxicDrum(float height, float diameter) {
        super(height, diameter);
        this.toxicity = CLASS_III;
    }
     
    /**
     * This is the overloaded constructor with height, diameter and contents and
     * toxicicty initialized as CLASS_III
     * @param height: This is the height of the drum.
     * @param diameter:This is the diameter of the drum.
     * @param contents: The contents of the drum.
     * */
    public ToxicDrum(float height, float diameter, String contents) {
        super(height, diameter, contents);
        this.toxicity = CLASS_III;
    }

    /**
     * This is the overloaded constructor with height, diameter and toxicity.
     * @param height: This is the height of the drum.
     * @param diameter:This is the diameter of the drum.
     * @param contents: The contents of the drum.
     * @param toxicity: The toxicity of the contents of the drum.
     * */
    public ToxicDrum(float height, float diameter, String contents, String toxicity) {
        super(height, diameter, contents);
        this.toxicity = toxicity;
    }

    /**
     * This is the setter of the toxicity.
     * */
    public void setToxicity(String toxicity) {
        this.toxicity = toxicity;
    }

    /**
     * This is the getter of the toxicity.
     * */
    public String getToxicity() {
        return toxicity;
    }

    /**
     * This is the capacity method which is returning the volume by the formula 
     * pi* square of radius * height and contains a scalar factor of 0.02083.
     * */
    @Override
    public float capacity() {
        return (float) (0.75 * Math.PI * Math.pow(getDiameter() / 2, 2) * getHeight()/getHeight());
    }

    /**
     * This is the toString method which uses an if-else loop to display the 
     * variable names instead of the variable content. It includes height, diameter,
     * contents, capacity and toxicity class name.
     * */
    @Override
    public String toString() {
        String toxicityClassName = "Unknown"; // Default value

        if (toxicity.equals(CLASS_IA)) {
            toxicityClassName = "CLASS_IA";
        } else if (toxicity.equals(CLASS_IB)) {
            toxicityClassName = "CLASS_IB";
        } else if (toxicity.equals(CLASS_II)) {
            toxicityClassName = "CLASS_II";
        } else if (toxicity.equals(CLASS_III)) {
            toxicityClassName = "CLASS_III";
        }

        return "domain.ToxicDrum:ToxicDrum\n" +
               "    ::height:" + getHeight() +
               " diameter:" + getDiameter() +
               " contents:" + getContents() +
               " capacity:" + capacity() +
               " toxicity:" + toxicityClassName;
    }


}