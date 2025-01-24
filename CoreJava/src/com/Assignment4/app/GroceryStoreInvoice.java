package com.Assignment4.app;


import java.util.InputMismatchException;
import java.util.Scanner;

class GroseryStore {
	int part_number;
	String part_description;
	int quantity;
	double price;
	
	GroseryStore(int number, String description, int quantity, double price) {
		this.part_number = number;
		this.part_description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	void displayDetails() {
		System.out.println("Part Number: "+ this.part_number);
		System.out.println("Part Description: "+ this.part_description);
		System.out.println("Quantity of Item purchased: "+ this.quantity);
		System.out.println("Total price of Items: "+ this.quantity * this.price);
	}
}

public class GroceryStoreInvoice {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int partNumber = 0, quantity = 0;
        double pricePerItem = 0.0;
        String partDescription = "";

        // Validate part number input
        while (true) {
            try {
                System.out.print("Enter part number (greater than 0): ");
                partNumber = scan.nextInt();
                if (partNumber <= 0) {
                    System.out.println("Part number must be greater than 0.");
                    continue;
                }
                break;  // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer for part number.");
                scan.nextLine();  // Clear the invalid input
            }
        }

        // Validate part description input
        while (true)
        {
        	
  
            System.out.print("Enter part description (non-empty string): ");
            partDescription = scan.nextLine();
            if (partDescription == null || partDescription.trim().isEmpty()) {
                System.out.println("Part description cannot be null or empty.");
            } else {
                break;
            }
        }

        // Validate quantity input
        while (true) {
            try {
                System.out.print("Enter quantity (greater than 0): ");
                quantity = scan.nextInt();
                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer for quantity.");
                scan.nextLine();  // Clear the invalid input
            }
        }

        // Validate price per item input
        while (true) {
            try {
                System.out.print("Enter price per item (greater than 0): ");
                pricePerItem = scan.nextDouble();
                if (pricePerItem <= 0) {
                    System.out.println("Price per item must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for price.");
                scan.nextLine();  // Clear the invalid input
            }
        }

        // Create Invoice instance with validated inputs
        GroseryStore invoice = new GroseryStore(partNumber, partDescription, quantity, pricePerItem);

        System.out.println();
        // Display invoice details
        invoice.displayDetails();

        scan.close();
     }
}
