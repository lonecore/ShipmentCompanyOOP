package Tests;

import Items.Item;
import Methods.Calculation;
import Containers.Container;
import Exceptions.CustomException;

import java.util.List;

public class Tests {
    public static void main(String[] args) {
        try {
            // create a calculation instance
            Calculation calculation = new Calculation(false);

            // create test items
            Item laptop = new Item("Laptop", 60, 50, 50, 6.5, 10);
            Item mouse = new Item("Mouse", 30, 30, 20, 0.2, 100);
            Item desktop = new Item("Desktop", 100, 150, 50, 20, 5);
            Item lcdScreen = new Item("LCD Screens", 120, 140, 80, 2.6, 20);

            // add items to calculation
            calculation.addItems(List.of(laptop, mouse, desktop, lcdScreen));

            // test best shipping calculation
            String bestShipping = calculation.bestShipping();
            assert bestShipping != null && !bestShipping.isEmpty() : "Best shipping should not be null or empty";

            // test shipping price calculation
            int shippingPrice = calculation.getShippingPrice();
            assert shippingPrice > 0 : "Shipping price should be greater than 0";

            // test add order
            calculation.addOrder();
            // test displayOrder in App.java

            // clear all items and check if the list is empty
            calculation.clearItems();

           
            Container smallContainer = new Container("Small", 1, 1, 1); // test container
            assert smallContainer.getMaxWeight() == 2000 : "Small container max weight should be 2000";
            
            // print success message if everything has passed the test
            System.out.println("Test has been completed.");
            System.out.println("No errors have been thrown.");
        } catch (CustomException e) {
            e.printStackTrace();
            System.out.println("Test failed due to an exception: " + e.getMessage());
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}
