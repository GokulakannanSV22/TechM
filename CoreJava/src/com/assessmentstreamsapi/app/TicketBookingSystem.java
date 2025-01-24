package com.assessmentstreamsapi.app;

import java.util.*;

class InvalidFormatException extends Exception {
    public InvalidFormatException() {
        super("Invalid input format... Expected format: Name,Phone,SeatNumber.");
    }
}

class PhoneValidationException extends Exception {
    public PhoneValidationException() {
        super("Invalid phone number. Phone number must be numeric and exactly 10 digits.");
    }
}

public class TicketBookingSystem 
{
     HashMap<String, HashMap<String, String>> bookings = new HashMap<>();

    
    public String[] validateInput(String details) throws InvalidFormatException, PhoneValidationException 
    {
        String[] parts = details.split(",");
        if (parts.length != 3)
        {
            throw new InvalidFormatException();
        }

        String name = parts[0].trim();
        String phone = parts[1].trim();
        String seatNumber = parts[2].trim();
        if(phone.length() != 10)
        {
        	throw new PhoneValidationException();
        }

        
        

        return new String[]{name, phone, seatNumber};
    }

    
    private String generateBookingID(String name, String seatNumber)
    {
        String threeLetters = name.substring(0, 3).toUpperCase();
        int randomNumber = new Random().nextInt(9000) + 1000; 
        return threeLetters + randomNumber + seatNumber;
    }

    
    public void bookTicket(String details) {
        try {
            
            String[] validatedDetails = validateInput(details);
            String name = validatedDetails[0];
            String phone = validatedDetails[1];
            String seatNumber = validatedDetails[2];

            
            String bookingID = generateBookingID(name, seatNumber);

            
            HashMap<String, String> bookingDetails = new HashMap<>();
            bookingDetails.put("Name", name);
            bookingDetails.put("Phone", phone);
            bookingDetails.put("SeatNumber", seatNumber);

            bookings.put(bookingID, bookingDetails);

            
            System.out.println("Booking successful! Your booking ID is: " + bookingID);
        } 
        catch (InvalidFormatException | PhoneValidationException e) 
        {
            
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Scanner scan =  new Scanner(System.in);
        System.out.println("Enter Details...");
        System.out.println("Enter details of user 1 :");
        String user1 = scan.nextLine();
        System.out.println("Enter details of user 2 :");
        String user2 = scan.nextLine();
        

        
        List<String> Inputs = Arrays.asList(
            user1,
            user2
            
        );

        for (String details : Inputs) {
            System.out.println(details);
            system.bookTicket(details);
        }
    }
}
