
package Methods;
import Items.Item;
import Exceptions.CustomException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// class for calculation of shipping details
public class Calculation {
    private List<Item> items = new ArrayList<>(); // list to store items
    private List<Item> order = new ArrayList<>(); // list to store the final order
    private String bestShipment; // best shipment details
    private int shippingPrice; // total shipping price

    // method to add items to the order list
    public void addItems(List<Item> addItems) throws CustomException {
        // use a map to quickly find items by a unique key composed of name and dimensions
        Map<String, Item> itemMap = new HashMap<>();
        for (Item item : this.items) {
            String key = item.getName() + item.getDimensions();
            itemMap.put(key, item);
        }

        for (Item addItem : addItems) {
            String key = addItem.getName() + addItem.getDimensions();
            if (itemMap.containsKey(key)) {
                Item existingItem = itemMap.get(key);
                existingItem.setAmount(existingItem.getAmount() + addItem.getAmount());
            } else {
                this.items.add(addItem);
                itemMap.put(key, addItem);
            }
        }
    }

    // method to calculate total weight of all items
    private double totalWeight() {
        double totalWeight = 0;
        for (Item item : this.items) {
            totalWeight += item.getWeight() * item.getAmount();
        }
        return totalWeight;
    }

    // method to calculate total volume of all items
    private double totalVolume() {
        double totalVolume = 0;
        for (Item item : this.items) {
            totalVolume += item.getVolume() * item.getAmount();
        }
        return totalVolume;
    }

    // method to calculate amount of containers that are needed
    private int[] calculateContainersAmount() throws CustomException {
        double totalVolume = totalVolume();
        double totalWeight = totalWeight();

        int bigContainerVolume = 259 * 243 * 1201;
        int smallContainerVolume = 259 * 243 * 606;

        int numBigContainers = (int) Math.floor(totalVolume / bigContainerVolume);
        double remainingVolume = totalVolume % bigContainerVolume;

        int numSmallContainers = 0;
        if (remainingVolume > 0) {
            if (remainingVolume <= smallContainerVolume) {
                numSmallContainers = 1;
            } else {
                numBigContainers += 1;
            }
        }

        // check if using a combination of big and small containers is cheaper
        if (numBigContainers > 1 && remainingVolume <= smallContainerVolume && totalWeight <= 500) {
            numBigContainers -= 1;
            numSmallContainers = 1;
        }

        int smallContainerWeightPrice = (totalWeight > 500) ? 1200 : 1000;

        int[] containerAmounts = {numBigContainers, numSmallContainers, smallContainerWeightPrice};
        return containerAmounts;
    }



    // method to calculate total shipping price
    private void calculateShippingPrice() throws CustomException {
        int[] containerAmounts = calculateContainersAmount();
        int bigContainers = containerAmounts[0];
        int smallContainers = containerAmounts[1];
        int smallContainerPrice = containerAmounts[2];

        shippingPrice = (bigContainers * 1800) + (smallContainers * smallContainerPrice);
    }

    // method to get the best shipping option
    public String bestShipping() throws CustomException {
        int[] containerAmounts = calculateContainersAmount();
        int bigContainers = containerAmounts[0];
        int smallContainers = containerAmounts[1];

        if (bigContainers == 0 && smallContainers == 0) {
            return "No containers needed";
        }

        if (smallContainers != 0) {
            return "Big Containers: " + bigContainers + "\nSmall Containers: " + smallContainers;
        } else {
            return "Big Containers: " + bigContainers;
        }
    }

    // method to add the current items to the order and calculate shipment information
    public void addOrder() throws CustomException {
        this.order = new ArrayList<>(this.items);
        this.bestShipment = this.bestShipping();
        this.shippingPrice = getShippingPrice();
    }

    // method to display the information of the current order
    public void displayOrder() {
        if (this.order.isEmpty()) {
            System.out.println("No order added");
        } else {
            // calculate overall volume and weight
            double totalVolume = 0;
            double totalWeight = 0;
            for (Item item : this.order) {
                totalVolume += item.getVolume() * item.getAmount(); // multiply by the amount to get the total volume
                totalWeight += item.getWeight() * item.getAmount(); // multiply by the amount to get the total weight
            }

            // print table header
            System.out.println("------------------ Order details ------------------");
            System.out.println("+--------------+--------------+---------------------+---------------+----------+");
            System.out.println("| Item Number  | Item Name    | Volume (m³)         | Weight        | Amount   |");
            System.out.println("+--------------+--------------+---------------------+---------------+----------+");

            // print item details in table
            for (int i = 0; i < this.order.size(); i++) {
                Item item = this.order.get(i);
                System.out.printf("| %-12d | %-12s | %-19.3f | %-13.1f | %-8d |\n",
                        (i + 1),
                        item.getName(),
                        (item.getVolume() * item.getAmount()) / 1000000.0, // convert cubic cm to cubic meters for total volume
                        item.getWeight() * item.getAmount(), // for the total weight
                        item.getAmount());
            }

            // table footer
            System.out.println("+--------------+--------------+---------------------+---------------+----------+");

            // print overall volume and weight
            System.out.printf("\nOverall Volume: %.3f m³\n", totalVolume / 1000000.0); // convert cm³ to m³
            System.out.printf("Overall Weight: %.1f kg\n\n", totalWeight); // display total weight

            // print order shipment information
            System.out.println("------------------ Order Shipment Info ------------------");
            System.out.println("Best Shipping:");
            System.out.println(this.bestShipment);
            System.out.println("Shipping price: " + this.shippingPrice);
            System.out.println("----------------------------------------------------------");
        }
    }
    // method to print information about all items
    public void printItemsInfo() {
        for (Item item : this.items) {
            item.printInfo();
        }
    }

    // method to clear all items
    public void clearItems() {
        this.items.clear();
    }

    // method to get total shipping price
    public int getShippingPrice() throws CustomException {
        calculateShippingPrice();
        return shippingPrice;
    }


}
