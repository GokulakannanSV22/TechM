package com.dateandtime.app;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateAndTime
{
	
	Scanner scan = new Scanner(System.in);
	public void EmployeeDetails()
	{
		LocalDate joining_date,date_of_birth,now;
		System.out.println("Enter Joining Date : ");
		String jd_input = scan.nextLine();
		System.out.println("Enter Date Of Birth : ");
		String dob_input = scan.nextLine();
		
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		joining_date = LocalDate.parse(jd_input, formatter);
		date_of_birth = LocalDate.parse(dob_input, formatter);
		
		System.out.println(joining_date);
		System.out.println(date_of_birth);
		System.out.println(date_of_birth.getDayOfWeek());
		
		now = LocalDate.now();
		System.out.println(now);
		
		int age = Period.between(date_of_birth,now).getYears();
		System.out.println(age);
	}
	public static void main(String [] args)
	{
		DateAndTime dt = new DateAndTime();
		dt.EmployeeDetails();
	}

}
