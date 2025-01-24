package com.streamapiprograms.app;
import java.time.LocalDate;
import java.util.stream.*;
import java.util.*;
public class Transaction
{
	String transaction_id;
	String acc_no;
	String trans_type;
	int amount;
	LocalDate trans_date;
	String merchant;
	
	public Transaction(String transaction_id, String acc_no, String trans_type, int amount, LocalDate trans_date, String merchant)
	{
		this.acc_no = acc_no;
		this.amount=amount;
		this.merchant = merchant;
		this.trans_date = trans_date;
		this.trans_type = trans_type;
		this.transaction_id = transaction_id;
	}
	
	int getAmount()
	{
		return amount;
	}
	
	public String toString()
	{
		
		return "Transaction_id : "+transaction_id+"\nAcc.No : "+acc_no+"\nTransaction_Type : "+trans_type
				+"\nAmount : "+amount+"\nTransaction_Date : "+trans_date+"\nMerchant : "+merchant+"\n"+"\n****----****";
		
	}
	

	public static void main(String [] args)
	{
		List<Transaction> transactions = Arrays.asList(
			    new Transaction("T001", "A123", "Credit", 5000, LocalDate.of(2025, 1, 5), "Amazon"),
			    new Transaction("T002", "A123", "Debit", 2000, LocalDate.of(2025, 1, 6), "Walmart"),
			    new Transaction("T003", "A123", "Debit", 7000, LocalDate.of(2025, 1, 7), "BestBuy"),
			    new Transaction("T004", "B456", "Credit", 10000, LocalDate.of(2025, 1, 5), "PayPal"),
			    new Transaction("T005", "A123", "Debit", 15000, LocalDate.of(2025, 1, 8), "Target"),
			    new Transaction("T006", "B456", "Debit", 8000, LocalDate.of(2025, 1, 9), "eBay")
			        );
		
		int treshold_amount=1000 ;
		System.out.println("Treshold Amount:"+treshold_amount);
		System.out.println("------------------------------------------");
		System.out.println("---Accounts Having Amounts Greater Than treshold---");
		transactions.stream().filter(a->a.amount>treshold_amount).forEach(a->System.out.println(a));
		int credit_total = transactions.stream()
				.filter(a->a.acc_no.equals("A123")&&a.trans_type.equalsIgnoreCase("credit"))
				.mapToInt(Transaction::getAmount)
				.sum();
		System.out.println("------------------------------------------");
		System.out.println("Credit Total of Account A123 : " + credit_total);
		
		int debit_total = transactions.stream()
				.filter(a->a.acc_no.equals("A123")&&a.trans_type.equalsIgnoreCase("debit"))
				.mapToInt(Transaction::getAmount)
				.sum();
		System.out.println("------------------------------------------");
		System.out.println("Debit Total of Account A123 : " + debit_total);
		
		
		
		long count =transactions.stream().filter(a->a.merchant.equalsIgnoreCase("amazon")).count();
		System.out.println("------------------------------------------");
		System.out.println("The count of transactions Which has merchant as Amazon : "+count);
		
		
		System.out.println("------------------------------------------");
		System.out.println("The Transactions in descending order based on Amount : ");
		transactions.stream()
				.sorted(Comparator.comparingInt(Transaction::getAmount).reversed())
				.forEach(a->System.out.println(a));
		System.out.println("------------------------------------------");
	}
}
