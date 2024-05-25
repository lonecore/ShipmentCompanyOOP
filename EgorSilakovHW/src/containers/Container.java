package containers;

public class Container {

    private double height;
    private double length;
    private double width;
    private double cost;
    private double weightLimit;

    public Container(double height, double length, double width, double cost, double weightLimit){

        this.height = height;
        this.length = length;
        this.width = width;
        this.cost = cost;
        this.weightLimit = weightLimit;

    }

    public double getVolume(){

        return height * width * length;

    }

    



}
