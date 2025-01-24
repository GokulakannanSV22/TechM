package com.collectionsprograms.app;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class HashMapLoginValidation 
{

	public static void main(String [] args)
	{
		User u1 = new User("Ichabod Crane","Qwerty123");
		User u2 = new User("Brom Bones","Pass456!");
		User u3 = new User("Emboar Pokeman","Password123");
		User u4 = new User("Rayquazza Pokeman","Drow456");
		User u5 = new User("Cool Dude","Dh456!32");
		Scanner scan = new Scanner(System.in);

		LinkedList<User> list1 = new LinkedList<>();
		list1.add(u1);
		
		list1.add(u2);
		
		list1.add(u3);
		
		list1.add(u4);
		
		list1.add(u5);
		
		HashMap<String,Integer> map  =  new HashMap<>();
		map.put("icrane", list1.indexOf(u1));
		map.put("bbones", list1.indexOf(u2));
		map.put("epokeman", list1.indexOf(u3));
		map.put("Rpokemon", list1.indexOf(u4));
		map.put("cdude", list1.indexOf(u5));
		
		int login_time=0;
		while(login_time < 3) 
		{
			System.out.print("Enter the Username:");
			String name = scan.nextLine();
			System.out.print("Enter the Password:");
			String password = scan.nextLine();
			
			if(map.containsKey(name)) 
			{
				
				int index = map.get(name);
				User user = list1.get(index);
				
				if(user.password.equals(password))
				{
					System.out.println("Successful Login!!!");
					System.out.println("Welcome " + user.fullName);
					return;
				}
				
			} 
			else
			{
				System.out.println("Invalid Username and Password");
				System.out.println();
				login_time++;
			}
		}

	
		
		
		
		
		
	}
}
