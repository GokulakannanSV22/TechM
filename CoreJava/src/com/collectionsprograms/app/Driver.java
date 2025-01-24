package com.collectionsprograms.app;


import java.util.PriorityQueue;
import java.util.Scanner;

class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Person other) {
        // Compare based on first name lexicographically
        return this.firstName.compareToIgnoreCase(other.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PriorityQueue to hold Person objects sorted by first name
        PriorityQueue<Person> queue = new PriorityQueue<>();

        System.out.print("Enter the number of people: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Input details of n people
        for (int i = 0; i < n; i++) {
            System.out.print("Enter first name and last name of person " + (i + 1) + ": ");
            String fullName = scanner.nextLine();
            String[] nameParts = fullName.split(" ");
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : ""; // Handle single name case
            queue.add(new Person(firstName, lastName));
        }

        System.out.println("\nPeople sorted lexicographically by first name:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        scanner.close();
    }
}
