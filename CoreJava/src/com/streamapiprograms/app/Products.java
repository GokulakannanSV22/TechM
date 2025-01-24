package com.streamapiprograms.app;

import java.util.Arrays;
import java.util.*;

public class Products 
{
	
	private String name;
	private String category;
	private double price;
	private int quantity;
	
	public Products(String name,String category,double price,int quantity)
	{
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getTotalPrice()
	{
		return price*quantity;
	}
	
	public String toString()
	{
		return "Name : "+name+"\nCategory : "+category+"\nPrice : "+price+"\nQuantity : "+quantity+"\n----------";
	}

	public static void main(String [] args)
	{
		List<Products> products_list = Arrays.asList(
				new Products("Laptop", "Electronics", 1000.0, 1),
				new Products("Smartphone", "Electronics", 700.0, 2),
				new Products("Book", "Literature", 20.0, 0),
				new Products("Headphones", "Electronics", 150.0, 3),
				new Products("Desk Lamp", "Home", 50.0, 2)
				);
				
		products_list.stream().filter(a->a.quantity != 0)
		.sorted(Comparator.comparing(Products::getTotalPrice).reversed())
		.limit(5)
		.forEach(a->System.out.println(a));
		
		
	
		
				
		
	}
}
