package com.Assignment4.app;
import java.util.Scanner;

	class InvalidUsernameException extends Exception {
	    public InvalidUsernameException(String message) {
	        super(message);
	    }
	}

	// Exception for invalid password
	class InvalidPasswordException extends Exception {
	    public InvalidPasswordException(String message) {
	        super(message);
	    }
	}

	public class ValidUserName {

	    // Method to validate username
	    public static boolean validateUsername(String username) throws InvalidUsernameException {
	        if (username.length() < 6 || username.length() > 30) {
	            throw new InvalidUsernameException("Username must be between 6 and 30 characters.");
	        } else if (!username.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
	            throw new InvalidUsernameException("Username must start with a letter and contain only alphanumeric characters or underscores.");
	        } else {
	        	return true;
	        }
	    }

	    // Method to validate password
	    public static boolean validatePassword(String password) throws InvalidPasswordException {
	        if (password.length() < 8) {
	            throw new InvalidPasswordException("Password must be at least 8 characters long.");
	        } else if (!password.matches(".*[a-z].*")) {
	            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
	        } else if (!password.matches(".[A-Z].*")) {
	            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
	        } else if (!password.matches(".[!@#$%^&()\\-+].*")) {
	            throw new InvalidPasswordException("Password must contain at least one special character (!@#$%^&*()-+).");
	        } else if (!password.matches(".\\d.")) {
	            throw new InvalidPasswordException("Password must contain at least one digit.");
	        } else {
	        	return true;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter username: ");
	        String inputUsername = scanner.nextLine();

	        System.out.print("Enter password: ");
	        String inputPassword = scanner.nextLine();

	        try {
	            // Validate user input
	            if(validateUsername(inputUsername) && validatePassword(inputPassword)) {
	            	System.out.println("Welcome!!! " + inputUsername);
	            }
	            
	        } catch (InvalidUsernameException | InvalidPasswordException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	}
	

