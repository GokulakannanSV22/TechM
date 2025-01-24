package com.Assignment4.app;

import java.util.Scanner;

class PayOutOfBoundException extends Exception {
	 public PayOutOfBoundException(String s) {
		super(s);
	}
}

public class AccountManagement {
	
	double balance = 80000;
	
	public void checkForDebit(double amount) throws PayOutOfBoundException {
		if(amount <= 0) {
			throw new PayOutOfBoundException("Invalid amount");
		}
		if (amount > 30000) {
			throw new PayOutOfBoundException("Couldn't process the Maximum is limit is 30000");
		} 
		if (amount > balance) {
			throw new PayOutOfBoundException("Insufficient balance");
		}
	}
	
	void withdramAmount(double amount) {
		try {
			checkForDebit(amount);
			balance -= amount;
			System.out.println("Successful transaction Account balance is "+ balance);
		} catch (PayOutOfBoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount to withdraw :");
		double money = scan.nextDouble();
		
		AccountManagement account = new AccountManagement();
		account.withdramAmount(money);

	}
}
