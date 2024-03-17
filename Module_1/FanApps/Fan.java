/*
 * Citations 
 * 
 * Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved.
 * 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by R. Krasso 2021
Additional modifications by A. Student 2021
 * 
 * 
 * 
 */



public class Fan {
    // constants provide a clear and consistent way to manage and represent the possible speed levels of the fan within the Fan class.
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    //This data field represents the speed of the fan. It is used to store the current speed level of the fan.
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    //This data represents two constructors in the Fan class: the first initializes a Fan object with default values, while the second initializes it with specified values provided as arguments
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6.0;
        this.color = "white";
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

   //This code defines accessor and mutator methods for the private data fields 
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //This code helps create a message about the fan's state
    @Override
    public String toString() {
        if (on) {
            return "The fan speed is set to " + speed + " with a color of " + color + " and a radius of " + radius;
        } else {
            return "The fan is " + color + " with a radius of " + radius + " and the fan is off";
        }
    }
}
