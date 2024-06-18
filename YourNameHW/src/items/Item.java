
package Items;

import Dimensions.PhysicalObject;
import Exceptions.CustomException;

import java.lang.reflect.Method;

//this class is a subclass of PhysicalObject, so basically it complements it
public class Item extends PhysicalObject {
    private final String name;
    private final double weight;
    private int amount;

    // constructor to get an item with its name, length etc.
    public Item(String name, double length, double width, double height, double weight, int amount) {
        super(length, width, height);
        this.name = name;
        this.weight = weight;
        this.amount = amount;
    }

    //method to get weight of the item
    public double getWeight()
    {return this.weight;}

    //method to get amount of the item
    public int getAmount()
    {return this.amount;}

    // method to get name of the item
    public String getName()
    {return this.name;}

    //method to set amount of items
    public void setAmount(int amount) throws CustomException { //throws and Exception if amount is negative
        if (amount < 0)
            throw new CustomException("Amount of items cannot be negative.");
        this.amount = amount;
    }

    @Override //overrides methods

    //overridden method to print information of the item
    public void printInfo() {
        System.out.println("Item Name: " + name +
                "\nDimensions: " + this.getDimensions() +
                "\nVolume: " + this.getVolume() + " cubic cm" +
                "\nWeight: " + this.weight + " kg");
    }

}
