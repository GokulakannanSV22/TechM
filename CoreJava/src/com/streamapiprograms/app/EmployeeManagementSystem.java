package com.streamapiprograms.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagementSystem
{

	private String name;
	private String department;
	private double salary;
	public EmployeeManagementSystem(String name, String department, double salary )
	{
		// TODO Auto-generated constructor stub
		this.department = department;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString()
	{
		return "Department with highest total salary : "+department+"and"+salary;
	}
	public String getDept()
	{
		return department;
	}
	public double getSalary()
	{
		return salary;
	}
	

	public static void main(String [] args)
	{
		List<EmployeeManagementSystem> employee = Arrays.asList(
				new EmployeeManagementSystem("Alice", "HR", 45000),
				new EmployeeManagementSystem("Bob", "Engineering", 75000),
				new EmployeeManagementSystem("Charlie", "Engineering", 60000),
				new EmployeeManagementSystem("David", "Sales", 50000),
				new EmployeeManagementSystem("Eve", "HR", 65000));
		
		Map.Entry<String,Double> max_salary =  employee.stream().filter(a->a.salary>=50000)
		.collect(Collectors.groupingBy(EmployeeManagementSystem::getDept
				,Collectors.summingDouble(EmployeeManagementSystem::getSalary))).entrySet()
		.stream().max(Map.Entry.comparingByValue()).orElse(null);
		
		System.out.println("Department with highest total salary : "+ max_salary.getKey()
		+" and "+max_salary.getValue());
		
		
		
		
	}
}
