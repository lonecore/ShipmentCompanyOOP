package main;

import items.Item;
import methods.Calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Laptop", 60, 50, 50, 6.5));
        items.add(new Item("Mouse", 30, 30, 20, 0.2));
        items.add(new Item("Desktop", 100, 150, 50, 20));
        items.add(new Item("LCD Screen", 120, 140, 80, 2.6));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Laptops:");
        int numLaptops = scanner.nextInt();
        System.out.println("Enter the number of Mice:");
        int numMice = scanner.nextInt();
        System.out.println("Enter the number of Desktops:");
        int numDesktops = scanner.nextInt();
        System.out.println("Enter the number of LCD Screens:");
        int numLCDScreens = scanner.nextInt();

        Calculation calculation = new Calculation();
        List<Item> order = calculation.addOrder(numLaptops, numMice, numDesktops, numLCDScreens);

        calculation.printItem(items);
        calculation.printOrder(order);
    }
}
