
package Dimensions;

public abstract class PhysicalObject {
    private final double[] dimensions = new double[3];

    // constructor to set the dimensions of the object
    public PhysicalObject(double length, double width, double height) {
        this.dimensions[0] = length;
        this.dimensions[1] = width;
        this.dimensions[2] = height;
    }

    // abstract method to be implemented by subclasses to print information about the object
    public abstract void printInfo();

    public String getDimensions() {
        return this.dimensions[0] + " x " + this.dimensions[1] + " x " + this.dimensions[2];
    }

    // method to calculate the surface area of the object
    public double getSurfaceArea() {
        double length = dimensions[0];
        double width = dimensions[1];
        double height = dimensions[2];
        return 2 * (length * width + length * height + width * height);
    }

    // method to check if the object fits inside a given container
    public boolean fitsInContainer(double containerLength, double containerWidth, double containerHeight) {
        double objectLength = dimensions[0];
        double objectWidth = dimensions[1];
        double objectHeight = dimensions[2];
        return objectLength <= containerLength && objectWidth <= containerWidth && objectHeight <= containerHeight;
    }

    // method to scale the dimensions of the object by a given factor
    public void scaleDimensions(double scaleFactor) {
        for (int i = 0; i < dimensions.length; i++) {
            dimensions[i] *= scaleFactor;
        }
    }

    // method to calculate the volume of the object
    public double getVolume() {
        return dimensions[0] * dimensions[1] * dimensions[2];
    }
    // method to get a string representation of the object's dimensions


    // method to print detailed information about the object
    public void printDetails() {
        System.out.println("Object Dimensions: " + getDimensions());
        System.out.println("Object Volume: " + getVolume() + " cubic cm");
        System.out.println("Object Surface Area: " + getSurfaceArea() + " square cm");
    }
}
