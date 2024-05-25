package items;

public class Item {
    private String name;
    private double length;
    private double width;
    private double height;
    private double weight;

    public Item(String name, double length, double width, double height, double weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return length * height * weight;
    }

    public double getWeight() {
        return weight;
    }

    public void printInfo() {
        System.out.println("Item: " + name);
        System.out.println("Volume: " + getVolume() + "cm³");
        System.out.println("Weight: " + weight + "kg");
    }
}
