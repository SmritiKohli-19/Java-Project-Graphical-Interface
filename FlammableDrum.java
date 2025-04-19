package domain;
/**File name: FlammableDrum.java
@author: Smriti Kohli , 041156272
Course : CST8132 - OOP
Assignment : Assignment 002
Date : March 16th, 2025
Professor: Amal Ibrahim 
Purpose :This is a class which extends abstract class Drum and represents a type of 
drum that contains flammable materials. 
Class List : Drum.java, FlammableDrum.java, ToxicDrum.java, Drum_Test.java, DrumPanel.java
*/

/**
* @author: Smriti Kohli
* @version: openjdk 21.0.4 2024-07-16 LTS
* @see: domain>object
* @since: javac 21.0.4
*/


/**
 * FlammableDrum class representing a drum that contains flammable materials and
 * extends abstract class Drum.
 */
public class FlammableDrum extends Drum {
    /**
     * This is the variable flashpoint declared as private with datatype float.
     * */
    private float flashpoint;
    
    /**
     * This is the default non-pramter constructor.
     * */
    public FlammableDrum() {
        super();
        this.flashpoint = 0.0f;
    }

    /**
     * This is the overloaded constructor with height and diameter and initializes the 
     * flashpoint to be 0.0f by default.
     * @param height: The height of the drum.
     * @param diameter:The diameter of the drum.
     * */
    public FlammableDrum(float height, float diameter) {
        super(height, diameter);
        this.flashpoint = 0.0f;
    }

    /**
     * This is the overloaded constructor with height, diameter and contents and
     * initializes the flashpoint to be 0.0f by default.
     * @param height: The height of the drum.
     * @param diameter:The diameter of the drum.
     * @param contents:The contents of the drum.
     * */
    public FlammableDrum(float height, float diameter, String contents) {
        super(height, diameter, contents);
        this.flashpoint = 0.0f;
    }

    /**
     * This is the overloaded constructor with height, diameter, contents and flashpoint.
     * @param height: The height of the drum.
     * @param diameter:The diameter of the drum.
     * @param contents:The contents of the drum.
     * @param flashpoint: The flashpoint of the drums contents.
     * */
    public FlammableDrum(float height, float diameter, String contents, float flashpoint) {
        super(height, diameter, contents);
        this.flashpoint = flashpoint;
    }

    /**
     * This is the setter for the flashpoint.
     * */
    public void setFlashpoint(float flashpoint) {
        this.flashpoint = flashpoint;
    }

    /**
     * This is the getter for the flashpoint.
     * */
    public float getFlashpoint() {
        return flashpoint;
    }

    /**
     * This is the capacity method which is returning the volume by the formula 
     * pi* square of radius * height
     * */
    @Override
    public float capacity() {
        return (float) (Math.PI * Math.pow(getDiameter()/2, 2) * getHeight()/getHeight());
    }

    /**
     * This is the toString method that includes height and capacity.
     * */
    @Override
    public String toString() {
        return "domain.FlammableDrum:FlammableDrum\n" + 
    "::height:" + getHeight() + 
    " diameter:" + getDiameter() +
    " contents:" + getContents() +
    ", capacity=" + capacity()+
    ", flashpoint:" + flashpoint  ;
    }
}