/**
 * This is the domain package.
 * */
package domain;
/*File name:Drum.java
@author: Smriti Kohli , 041156272
Course : CST8132 - OOP
Assignment : Assignment 002
Date : March 16th, 2025
Professor: Amal Ibrahim 
Purpose :This is an abstract class which has three variables which provides a base bluprint. 
Class List : Drum.java, FlammableDrum.java, ToxicDrum.java, Drum_Test.java, DrumPanel.java
*/

/**
* @author: Smriti Kohli
* @version: openjdk 21.0.4 2024-07-16 LTS
* @see: domain>object
* @since: javac 21.0.4
*/


/**
 * Drum class representing a basic drum with height, diameter, and contents.
 */
public abstract class Drum {
	/**
	 * This is the first variable height declared as private with a data-type float.
	 * */
    private float height;
    /**
	 * This is the second variable diameter declared as private with a data-type float.
	 * */
    private float diameter;
    /**
	 * This is the third variable declared as private with a data-type String.
	 * */
    private String contents;
    
    /**
	 * This is the default non-paramter constructor.
	 * */
    public Drum() {
        this.height = 0.0f;
        this.diameter = 0.0f;
        this.contents = "UNKNOWN";
    }

    /**
	 * This is the overloaded constructor with the height , diameter and initializes
	 * contents to unknown.
	 * @param height: The height of the drum.
	 * @param diameter: The diameter of the drum.
	 * */
    public Drum(float height, float diameter) {
        this.height = height;
        this.diameter = diameter;
        this.contents = "UNKNOWN";
    }

    /**
     * This is the overloded constructor with the height, diameter and contents.
     * @param height: The height of the drum. 
     * @param diameter: The diameter of the drum.
     * @param contents: The contents of the drum.
     * */
    public Drum(float height, float diameter, String contents) {
        this.height = height;
        this.diameter = diameter;
        this.contents = contents;
    }

    /**
     * This is the setter for height.
     * */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * This is the setter for diameter.
     * */
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    /**
     * This is the setter for contents.
     * */
    public void setContents(String contents) {
        this.contents = contents;
    }
    
    /**
     * This is the getter for height.
     * */
    public float getHeight() {
        return height;
    }
    
    /**
     * This is the getter for diameter.
     * */
    public float getDiameter() {
        return diameter;
    }
    
    /**
     * This is the getter for contents.
     * */
    public String getContents() {
        return contents;
    }

    /**
     * This is an abstract method capacity. 
     * */    
    public abstract float capacity();

    /**
     * This is the toString method that includes height, diameter and contents.
     * */  
    @Override
    public String toString() {
        return "Drum [height=" + height + ", diameter=" + diameter + ", contents=" + contents + "]";
    }
}