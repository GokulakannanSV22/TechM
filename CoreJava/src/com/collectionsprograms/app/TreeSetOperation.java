package com.collectionsprograms.app;

import java.util.*;

public class TreeSetOperation {
	void DisplayAllWords(TreeSet<String> words) {
		System.out.println("Display all words.");
		for(String word:words) {
			System.out.println(word);
		}
	}
	
	void CapitalizePlural(TreeSet<String> words) {
		System.out.println("Display with Capitalized Plurals.");
		for(String word:words) {
			if(word.endsWith("s"))
				System.out.println(word.toUpperCase()); 
			else
				System.out.println(word);
		}
	}
	
	void Reverse(TreeSet<String> words) {
		System.out.println("Display in Reverse Order.");
		for (String word : words) {
			String reverse = "";
            for(int i=0;i<word.length();i++) {
            	reverse=word.charAt(i)+reverse;
            }
            System.out.println(reverse);
        }
	}
	
	void RemovePluralWord(TreeSet<String> words) {
		System.out.println("Display with Plural Words Removed.");
		for(String word:words) {
			if(!word.endsWith("s"))
				System.out.println(word);
		}
	}
	
	public static void main(String[] args) {
		TreeSet<String> words = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word ('stop' to end): ");
		while(true) {
			String word = sc.nextLine();
			if(!word.equals("stop"))
				words.add(word);
			else
				break;
		}
		TreeSetOperation t = new TreeSetOperation();
		int choice = 0;
		do {
		System.out.println("1. Display all words.");
		System.out.println("2. Display with Capitalized Plurals.");
		System.out.println("3. Display in Reverse Order.");
		System.out.println("4. Display with Plural Words Removed.");
		System.out.println("5. Exit.");
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			t.DisplayAllWords(words);
			break;
		case 2:
			t.CapitalizePlural(words);
			break;
		case 3:
			t.Reverse(words);
			break;
		case 4:
			t.RemovePluralWord(words);
			break;
		case 5:
			System.out.println("Exiting....");
			return;
		default:
			System.out.println("Invalid choice. Please enter valid choice!");
			
		}
		} while(choice!=5);
		sc.close();
		
	}
}
