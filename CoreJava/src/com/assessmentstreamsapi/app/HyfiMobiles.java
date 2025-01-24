package com.assessmentstreamsapi.app;



import java.io.*;
import java.util.*;

class Mobile implements Serializable {
    private int productId;
    private String brandName;
    private String modelName;
    private int memory;
    private int price;
    private String colour;

    public Mobile(int productId, String brandName, String modelName, int memory, int price, String colour) {
        this.productId = productId;
        this.brandName = brandName;
        this.modelName = modelName;
        this.memory = memory;
        this.price = price;
        this.colour = colour;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "productId=" + productId +
                ", price=" + price +
                '}';
    }
}

class MobileManagementSystem {
    private static final String FILE_NAME = "mobiles.ser";

    public Map<Integer, Integer> filterMobilesByPriceRange(int minRange, int maxRange) {
        Map<Integer, Integer> resultMap = new TreeMap<>(Comparator.comparingInt(a -> a)); // Sorted by price (ascending)

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Mobile> mobiles = (List<Mobile>) ois.readObject();

            for (Mobile mobile : mobiles) {
                if (mobile.getPrice() >= minRange && mobile.getPrice() <= maxRange) {
                    resultMap.put(mobile.getProductId(), mobile.getPrice());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading mobile data: " + e.getMessage());
        }

        return resultMap;
    }
}

public class HyfiMobiles{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MobileManagementSystem managementSystem = new MobileManagementSystem();

        System.out.print("Enter minimum price range: ");
        int minRange = scanner.nextInt();

        System.out.print("Enter maximum price range: ");
        int maxRange = scanner.nextInt();

        Map<Integer, Integer> filteredMobiles = managementSystem.filterMobilesByPriceRange(minRange, maxRange);

        if (filteredMobiles.isEmpty()) {
            System.out.println("No mobiles found for the given range.");
        } else {
            System.out.println("Filtered Mobiles (Product ID: Price):");
            filteredMobiles.forEach((productId, price) -> System.out.println(productId + ": " + price));
        }
    }
}