
package Tests;

import Items.Item;
import Methods.Calculation;
import Methods.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// main application class for testing item ordering and shipping calculations
public class App {

    // method to create a list of provided items
    private static List<Item> createOrderList(int[] itemQuantities) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Laptop", 60, 50, 50, 6.5, itemQuantities[0]));
        itemList.add(new Item("Mouse", 30, 30, 20, 0.2, itemQuantities[1]));
        itemList.add(new Item("Desktop", 100, 150, 50, 20, itemQuantities[2]));
        itemList.add(new Item("LCD Screens", 120, 140, 80, 2.6, itemQuantities[3]));
        return itemList;
    }

    // main method to run the application
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); // scanner to read user input
        Calculation calculation = new Calculation(); // create a calculation instance with verbose mode off

        int[] itemQuantities = new int[4]; // array to store the quantities of each item

        // prompt the user to input the quantities of each item
        System.out.print("Enter the number of Laptops you want to order: ");
        itemQuantities[0] = Utils.getValidIntegerInput(scanner); // Use Utils method for input validation
        System.out.print("Enter the number of Mouses you want to order: ");
        itemQuantities[1] = Utils.getValidIntegerInput(scanner); // Use Utils method for input validation
        System.out.print("Enter the number of Desktops you want to order: ");
        itemQuantities[2] = Utils.getValidIntegerInput(scanner); // Use Utils method for input validation
        System.out.print("Enter the number of LCD Screens you want to order: ");
        itemQuantities[3] = Utils.getValidIntegerInput(scanner); // Use Utils method for input validation

        // add the items to the calculation and process the order
        calculation.addItems(createOrderList(itemQuantities));
        calculation.addOrder();
        calculation.displayOrder(); // display the order details

        scanner.close(); // close the scanner
    }
}
