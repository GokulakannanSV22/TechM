package com.collectionsprograms.app;
import java.util.LinkedHashMap;
public class LinkedHashMapVehicle 
{
	
	
	
	public static void main(String [] args)
	{
		LinkedHashMap<String,String> vehicleTypeMap = new LinkedHashMap<>();
		vehicleTypeMap.put("car", "sedan");
		vehicleTypeMap.put("truck", "pickup");
		vehicleTypeMap.put("motorcycle", "sportsbike");
		vehicleTypeMap.put("van", "minivan");
		vehicleTypeMap.put("suv", "crossover");
		System.out.println("---Initial Vehicle Map---");
		for(var s: vehicleTypeMap.entrySet())
		{
			System.out.println(s);
			
		}
		System.out.println();
		LinkedHashMap<String, String> copyMap = new LinkedHashMap<String, String>(vehicleTypeMap);
		System.out.println("VehicleMap copied to CopyMap...");
		System.out.println();
		
		System.out.println("What is vehicle type motorcycle contain?..");
		System.out.println(copyMap.get("motorcycle"));
		System.out.println();
		
		System.out.println("Van removed..");
		vehicleTypeMap.remove("van");
		System.out.println();
		
		System.out.println("does map have a Vehicle Type called suv?");
		System.out.println(vehicleTypeMap.containsKey("suv"));
		System.out.println();
		
		System.out.println("does map have a category pickup?");
		System.out.println(vehicleTypeMap.containsValue("pickup"));
		System.out.println();
		
		System.out.println("Is HashMap empty?");
		System.out.println(vehicleTypeMap.isEmpty());
		System.out.println();
		
		System.out.println("Size of the HashMap:");
		System.out.println(vehicleTypeMap.size());
		System.out.println();
		
		System.out.println("Key-Value Pair:");
		for(var s: vehicleTypeMap.entrySet())
		{
			System.out.println(s);
			
		}
		System.out.println();
		
		System.out.println("---Vehicle Types---");
		for(var s: vehicleTypeMap.entrySet())
		{
			System.out.println(s.getKey());
			
		}
		System.out.println();
		
		System.out.println("---Vehicle categories---");
		for(var s: vehicleTypeMap.entrySet())
		{
			System.out.println(s.getValue());
			
		}
		
		
		
		
		
		
	}

}
