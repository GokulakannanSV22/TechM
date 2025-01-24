package com.Assignment4.app;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Exception for invalid employee code
class InvalidEmpNumberException extends Exception {
    public InvalidEmpNumberException(String message) {
        super(message);
    }
}

// Exception for invalid date of joining
class InvalidDateOfJoinException extends Exception {
    public InvalidDateOfJoinException(String message) {
        super(message);
    }
}

// Employee class
class Employee {
    private int empCode;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfAppointment;

    // Constructor
    /**
     * 
     * @param empCode
     * @param name
     * @param dateOfBirth
     * @param dateOfAppointment
     */
    public Employee(int empCode, String name, LocalDate dateOfBirth, LocalDate dateOfAppointment) {
        this.empCode = empCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAppointment = dateOfAppointment;
    }

    // Method to calculate years of experience
    public int getYearsOfExperience() {
        return Period.between(dateOfAppointment, LocalDate.now()).getYears();
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("Employee Code: " + empCode);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Date of Appointment: " + dateOfAppointment);
        System.out.println("Years of Experience: " + getYearsOfExperience());
    }
}

public class EmployeeManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input employee details
            System.out.print("Enter Employee Code: ");
            int empCode = Integer.parseInt(scanner.nextLine());
            if (empCode <= 0) {
                throw new InvalidEmpNumberException("Employee code must be a positive integer.");
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            String dobInput = scanner.nextLine();

            System.out.print("Enter Date of Appointment (yyyy-MM-dd): ");
            String doaInput = scanner.nextLine();

            // Parse dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(dobInput, formatter);
            LocalDate dateOfAppointment = LocalDate.parse(doaInput, formatter);

            // Validate date of appointment
            if (!dateOfAppointment.isAfter(dateOfBirth)) {
                throw new InvalidDateOfJoinException("Date of appointment must be after date of birth.");
            }

            // Create Employee object
            Employee employee = new Employee(empCode, name, dateOfBirth, dateOfAppointment);

            // Display details
            System.out.println("\nEmployee Details:");
            employee.displayDetails();

        } catch (InvalidEmpNumberException | InvalidDateOfJoinException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Employee code must be a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
