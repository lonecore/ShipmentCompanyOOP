
package Containers;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Container {
    // fields for container props
    private String type;
    private double maxWeight;
    private double length;
    private double width;
    private double height;
    private List<Item> items;
    private double usedVolume;
    private double usedWeight;

    // constructor to initialize container with its type and dimensions
    public Container(String type, double length, double width, double height) {
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.items = new ArrayList<>();
        this.usedVolume = 0;
        this.usedWeight = 0;

        // set maximum weight based on container type
        if (type.equals("Big")) {
            this.maxWeight = 5000;
        } else if (type.equals("Small")) {
            this.maxWeight = 2000;
        } else {
            this.maxWeight = 0;
        }
    }

    // method to calculate volume of the containers
    public double getVolume() {
        return length * width * height;
    }

    // method to calculate the unused volume in the container
    public double getUnusedSpace() {
        return getVolume() - usedVolume;
    }

    // method to calculate the unused weight capacity in the container
    public double getUnusedWeight() {
        return maxWeight - usedWeight;
    }

    // method to get the maximum weight capacity of the container
    public double getMaxWeight() {
        return maxWeight;
    }

    // method to get the current used weight in the container
    public double getWeight() {
        return usedWeight;
    }

    // method to add items to the container
    public void addItem(Item item, int amount) {
        this.items.add(item);
        this.usedVolume += item.getVolume() * amount;
        this.usedWeight += item.getWeight() * amount;
    }

    // method to print information about the container
    public void printInfo() {
        System.out.println("Container type: " + this.type + "\n Volume: " + this.getUnusedSpace() + " cm^3");
    }
}
