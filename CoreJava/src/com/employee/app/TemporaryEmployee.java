package com.employee.app;

public class TemporaryEmployee extends Employee
{
	private int hours_worked;
	private int hourly_wages;
	//Default constructor if the user does not calls the parameterized constructor
	public TemporaryEmployee()
	{
		
	}
	/**
	 * Parameterized constructor to set values 
	 * @param employee_id
	 * @param employee_name
	 * @param hours_worked
	 * @param hourly_wages
	 */
	public TemporaryEmployee(int employee_id,String employee_name,int hours_worked,int hourly_wages)
	{
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.hours_worked = hours_worked;
		this.hourly_wages = hourly_wages;
	}
	/**
	 * Used to set hours Worked by an Employee 
	 * @param hours_worked
	 */
	public void setEmployee_hours_worked(int hours_worked)
	{
		this.hours_worked = hours_worked;
	}
	
	/**
	 * used to Set hourly wages for an Employee
	 * @param hourly_wages
	 */
	public void setEmployee_hourly_wages(int hourly_wages)
	{
		this.hourly_wages = hourly_wages;
	}
	
	public int getEmployee_hours_worked()
	{
		return this.hours_worked;
	}
	public int getEmployee_hourly_wages()
	{
		return this.hourly_wages;
	}
	
	
	public void calculateSalary()
	{
		this.salary = this.hourly_wages * this.hours_worked ; 
	}
	
	public void setEmployee_salary(int salary)
	{
		this.salary = salary;
	}
	public double getEmployee_salary()
	{
		return this.salary;
	}
	
}
