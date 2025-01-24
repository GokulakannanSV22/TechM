package com.streamapiprograms.app;
import java.util.*;
public class ListOfStudents
{
	private String name;
	private int age;
	private float avg_grade;
	
	public ListOfStudents(String name,int age,float avg_grade)
	{
		this.name = name;
		this.avg_grade = avg_grade;
		this.age = age;
	}
	
	public float getAvggrade()
	{
		return avg_grade;
	}
	public String toString()
	{
		return "Name : "+name+"\nAge : "+age+"\nAverage Grade : "+avg_grade+"\n-------------------------";
	}
	
	
	public static void main(String [] args)
	{
		List<ListOfStudents> students = Arrays.asList(
				new ListOfStudents("Alice", 17, 85.5f),
				new ListOfStudents("Bob", 19, 75.2f),
				new ListOfStudents("Charlie", 20, 95.0f),
				new ListOfStudents("David", 22, 65.4f),
				new ListOfStudents("Eve", 18, 88.3f)
				);
		
		
		System.out.println("Top 3 Students with Highest Average Grades:");
		students.stream().filter(a->a.age >= 18)
		.sorted(Comparator.comparingDouble(ListOfStudents::getAvggrade).reversed())
		.limit(3)
		.forEach(a->System.out.println(a));
		
		
		
		
		
		
		
		
		
	
	}
}
