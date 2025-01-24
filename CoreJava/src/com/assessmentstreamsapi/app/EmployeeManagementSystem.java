package com.assessmentstreamsapi.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeManagementSystem 
{
	
	
	
	private String emp_id;
	private String emp_name;
	private String emp_dept;
	private double salary;
	private LocalDate joining_date;
	
	
	
	public EmployeeManagementSystem(String emp_id, String emp_name,String emp_dept, double salary, LocalDate joining_date)
	{
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.joining_date = joining_date;
		this.salary = salary;
	}
	
	public int getMonth()
	{
		return joining_date.getMonthValue();
	}
	public String toString()
	{
		return "Employee Name:"+emp_name+"\nEmployee id : "+emp_id+"\nEmployee Department : "+emp_dept
				+"\nEmployee Salary : "+salary+"\nEmployee Joining Date : "+joining_date+"\n----------";
	}
	public String getDept()
	{
		return emp_dept;
	}



	public static void main(String [] args)
	{
		
		
		
		
		List<EmployeeManagementSystem> emp_list = Arrays.asList(
				new EmployeeManagementSystem("emp_100","ChakaraPandi","Cleaning",450000,LocalDate.of(2022, 1, 5)),
				new EmployeeManagementSystem("emp_101","Harold","Cooking",550000,LocalDate.of(2023, 2, 25)),
				new EmployeeManagementSystem("emp_102","Velu","Cleaning",400000,LocalDate.of(2020, 1, 25)),
				//new EmployeeManagementSystem(emp_id,emp_name,emp_dept,emp_salary,joining_date),
				new EmployeeManagementSystem("emp_103","Leodas","Cooking",540000,LocalDate.of(2024, 1, 25)),
				new EmployeeManagementSystem("emp_104","Dante","Cleaning",450000,LocalDate.of(2025, 3, 25)))
				;
		
		LocalDate now = LocalDate.now();
		int get_month = now.getMonthValue();
		System.out.println("Employees who have Work Anniversary this Month:");
		 emp_list.stream().filter(a->a.getMonth() == get_month).forEach(a->System.out.println(a));
		 
		long emp_department_cleaning =  emp_list.stream().filter(a->a.getDept().equalsIgnoreCase("cleaning")).count();
		long emp_department_cooking =  emp_list.stream().filter(a->a.getDept().equalsIgnoreCase("cooking")).count();
		System.out.print("No.of Employees on the department Cooking : ");
		System.out.println(emp_department_cooking);
		System.out.print("No.of Employees on the department Cleaning : ");
		System.out.println(emp_department_cleaning);
		
	long count =	emp_list.stream().collect(Collectors.groupingBy(EmployeeManagementSystem::getDept)).values().size();
	System.out.println(count);
	
		 
		 
		 
		 
		 
		 
	}

}
