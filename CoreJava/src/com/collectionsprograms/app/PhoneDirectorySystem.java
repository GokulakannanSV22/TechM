package com.collectionsprograms.app;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class PhoneDirectorySystem 
{
	
	
	
	
	
	public void add(LinkedHashMap<String,Long> phone_directory)
	{
		Scanner scan =  new Scanner(System.in);
		System.out.println("enter your name:");
		String name_input = scan.nextLine();
		System.out.println("Enter your phone number:");
		long phone_input = scan.nextLong();
		phone_directory.put(name_input, phone_input);
		
	}
	
	
	public void check(LinkedHashMap<String,Long> phone_directory)
	{
		Scanner scan =  new Scanner(System.in);
		System.out.println("enter name to find phone number:");
		String input_username = scan.nextLine();
		if(phone_directory.containsKey(input_username))
		{
			System.out.println(phone_directory.get(input_username));
		}
		else
		{
			System.out.println("Name does not exist...");
		}
	}
	
	public void update(LinkedHashMap<String,Long>phone_directory)
	{
		Scanner scan =  new Scanner(System.in);
		System.out.println("Enter name : ");
		
		String input_username = scan.nextLine();
		System.out.println("Enter phonenumber : ");
		long input_phonenumber = scan.nextLong();
		if(phone_directory.containsKey(input_username))
		{
			phone_directory.replace(input_username, input_phonenumber);
			
		}
		else
		{
			phone_directory.put(input_username, input_phonenumber);
		}
	}
	
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String,Long> phone_directory = new LinkedHashMap<>();
		phone_directory.put("chakarapandi", 123456789L);
		phone_directory.put("Leodas", 123451245L);
		phone_directory.put("ThookuDurai", 789456123L);
		phone_directory.put("AyyaDurai", 123456789L);
		phone_directory.put("Boss", 123456789L);
		PhoneDirectorySystem p1 = new PhoneDirectorySystem();
		while(true)
		{
			System.out.println("1.Find Number\n2.Update Number\n3.Add Number\n4.Exit");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
			case 1:
				p1.check(phone_directory);
				break;
			case 2:
				p1.update(phone_directory);
				break;
			case 3:
				p1.add(phone_directory);
				break;
			case 4:
				return;
				
			}
		}
	}

}



