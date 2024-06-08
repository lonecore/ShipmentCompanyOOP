package methods;

import items.Item;
import containers.Container;
import containers.SmallContainer;
import containers.BigContainer;

import java.util.List;
import java.util.ArrayList;

public class Calculation {
    // Method to calculate total volume of items in cubic meters
    public double totalVolume(List<Item> items) {
        double totalVolume = 0;
        for (Item item : items) {
            totalVolume += item.getVolume() / 1_000_000; // Convert cm³ to m³
        }
        return totalVolume;
    }

    // Method to calculate total weight of items
    public double totalWeight(List<Item> items) {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    // Method to determine the best shipping method based on volume and weight
    public String bestShipping(List<Item> items) {
        double totalVolume = totalVolume(items);
        double totalWeight = totalWeight(items);
        double bigContainerVolume = new BigContainer().getVolume();
        double smallContainerVolume = new SmallContainer().getVolume();
        double bigContainerCost = new BigContainer().getCost(totalWeight);
        double smallContainerCost = new SmallContainer().getCost(totalWeight);

        int numBigContainers = (int) Math.ceil(totalVolume / bigContainerVolume);
        int numSmallContainers = (int) Math.ceil(totalVolume / smallContainerVolume);

        double costWithBigContainers = numBigContainers * bigContainerCost;
        double costWithSmallContainers = numSmallContainers * smallContainerCost;

        return costWithBigContainers <= costWithSmallContainers ?
                numBigContainers + " Big Container(s)" : numSmallContainers + " Small Container(s)";
    }

    public double shippingPrice(List<Item> items) {
        double totalVolume = totalVolume(items);
        double totalWeight = totalWeight(items);
        double bigContainerVolume = new BigContainer().getVolume();
        double smallContainerVolume = new SmallContainer().getVolume();
        double bigContainerCost = new BigContainer().getCost(totalWeight);
        double smallContainerCost = new SmallContainer().getCost(totalWeight);

        int numBigContainers = (int) Math.ceil(totalVolume / bigContainerVolume);
        int numSmallContainers = (int) Math.ceil(totalVolume / smallContainerVolume);

        double costWithBigContainers = numBigContainers * bigContainerCost;
        double costWithSmallContainers = numSmallContainers * smallContainerCost;

        return Math.min(costWithBigContainers, costWithSmallContainers);
    }

    public void addItems(List<Item> items, Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public List<Item> addOrder(int numLaptops, int numMice, int numDesktops, int numLCDScreens) {
        List<Item> order = new ArrayList<>();
        addItems(order, new Item("Laptop", 60, 50, 50, 6.5), numLaptops);
        addItems(order, new Item("Mouse", 30, 30, 20, 0.2), numMice);
        addItems(order, new Item("Desktop", 100, 150, 50, 20), numDesktops);
        addItems(order, new Item("LCD Screen", 120, 140, 80, 2.6), numLCDScreens);
        return order;
    }

    public void printItem(List<Item> items) {
        for (Item item : items) {
            item.printInfo();
        }
    }

    public void printOrder(List<Item> items) {
        System.out.println("Total Volume: " + totalVolume(items) + " m³");
        System.out.println("Total Weight: " + totalWeight(items) + " kg");
        System.out.println("Best Shipping Option: " + bestShipping(items));
        System.out.println("Shipping price: " + shippingPrice(items) + " Euros");
    }
}
