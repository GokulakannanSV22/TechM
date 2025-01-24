package com.collectionsprograms.app;

import java.util.TreeMap;

public class TreeMapPractice 
{
	public static void main(String [] args)
	{
		TreeMap<String,Integer> studentMap = new TreeMap<>();
		studentMap.put("Alice", 20);
		studentMap.put("Bob", 22);
		studentMap.put("Charlie", 18 );
		studentMap.put("David", 25);
		studentMap.put("Eva", 21);
		System.out.println("---Initial Student Map---");
		for(var s: studentMap.entrySet())
		{
			System.out.println(s);
			
		}
		System.out.println();
		
		
		
		
		
		System.out.println("Charlie removed..");
		studentMap.remove("charlie");
		System.out.println();
		
		System.out.println("does Student map have bob ?");
		System.out.println(studentMap.containsKey("bob"));
		System.out.println();
		
		System.out.println("---Student Map Status---");
		
		System.out.println("Is StudentMap empty?");
		System.out.println(studentMap.isEmpty());
		System.out.println();
		
		System.out.println("Size of the StudentMap:");
		System.out.println(studentMap.size());
		System.out.println();
		
		System.out.println("Key-Value Pair:");
		for(var s: studentMap.entrySet())
		{
			System.out.println(s);
			
		}
		System.out.println();
		
		System.out.println("Minimum Key...");
		System.out.println(studentMap.firstKey());
		System.out.println();
		
		System.out.println("Maximum Key...");
		System.out.println(studentMap.lastKey());
		System.out.println();
		
		System.out.println("Polling first Entry...");
		System.out.println(studentMap.pollFirstEntry());
		System.out.println();
		
		System.out.println("Polling last Entry...");
		System.out.println(studentMap.pollLastEntry());
		
		
	}

}
