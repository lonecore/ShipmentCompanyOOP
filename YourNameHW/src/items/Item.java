
package Items;

import BaseObject.Object;
import Exceptions.CustomException;

// class item, which extends the object class
public class Item extends Object {
    private final String name; // name of the item
    private final double weight; // weight of the item
    private int amount; // amount of the item

    // constructor to initialize an item with its name, dimensions, weight, and amount
    public Item(String name, double length, double width, double height, double weight, int amount) {
        super(length, width, height);
        this.name = name;
        this.weight = weight;
        this.amount = amount;
    }

    // method to get the weight of the item
    public double getWeight() {
        return this.weight;
    }

    // method to get the amount of the item
    public int getAmount() {
        return this.amount;
    }

    // method to get the name of the item
    public String getName() {
        return this.name;
    }

    // method to set the amount of the item, throws an exception if amount is negative
    public void setAmount(int amount) throws CustomException {
        if (amount < 0)
            throw new CustomException("Amount of items cannot be negative.");
        this.amount = amount;
    }

    // overridden method to print the item information
    @Override
    public void printInfo() {
        System.out.println("Item Name: " + name + "\nVolume: " + this.getVolume() + " cm^3" + "\nWeight: " + this.weight + "\nDimensions: " + this.getDimensions());
    }
}
