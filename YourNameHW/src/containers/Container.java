package containers;

public class Container {
    private double height;
    private double width;
    private double length;
    private double cost;
    private double weightLimit;

    public Container(double height, double width, double length, double cost, double weightLimit) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.cost = cost;
        this.weightLimit = weightLimit;
    }

    public double getVolume() {
        return height * width * length;
    }

    public double getCost(double totalWeight) {
        if (weightLimit == 500) {
            return totalWeight <= 500 ? cost : cost + 200;
        } else {
            return cost;
        }
    }

    public void printInfo() {
        System.out.println("Container Volume: " + getVolume() + " m³");
    }
}
