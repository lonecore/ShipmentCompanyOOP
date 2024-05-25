package containers;

public class Container {

    private double height;
    private double length;
    private double width;
    private double weightLimit;

    public Container(double height, double length, double width, double weightLimit){

        this.height = height;
        this.length = length;
        this.width = width;
        this.weightLimit = weightLimit;

    }

    public double getVolume(){

        return height * width * length;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public void printInfo(){

        System.out.println("Container Volume: " + getVolume() + "m³");

    }

    



}
