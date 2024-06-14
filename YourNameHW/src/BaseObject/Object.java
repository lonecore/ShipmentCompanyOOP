

package BaseObject;

import java.util.Arrays;

public abstract class Object {
    // array to store the dimensions of the object (length, width, height)
    private final double[] dimensions = new double[3];

    // constructor to initialize the dimensions of the object
    public Object(double length, double width, double height) {
        this.dimensions[0] = length;
        this.dimensions[1] = width;
        this.dimensions[2] = height;
    }

    // abstract method to be implemented in subclasses
    public abstract void printInfo();

    // method to calculate volume of objects
    public double getVolume() {
        return Arrays.stream(this.dimensions).reduce(1, (a, b) -> a * b);
    }

    // method to get a string representation of the dimensions of the object
    public String getDimensions() {
        return this.dimensions[0] + " x " + this.dimensions[1] + " x " + this.dimensions[2];
    }
}
