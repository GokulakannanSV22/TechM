package com.employee.app;

public class PermanentEmployee extends Employee
{
	private double basic_pay;
	//Default constructor if the user does not calls the parameterized constructor
	public PermanentEmployee()
	{
		
	}
	/**
	 * Parameterized constructor used to set the attributes of an employee
	 * @param employee_id
	 * @param employee_name
	 * @param basic_pay
	 */
	public PermanentEmployee(int employee_id,String employee_name,double basic_pay)
	{
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.basic_pay = basic_pay;
	}
	/**
	 * used to set value for basic pay of an employee
	 * @param basic_pay
	 */
	public void setEmployee_basicpay(double basic_pay)
	{
		this.basic_pay = basic_pay;
	}
	public double getEmployee_basicpay()
	{
		return this.basic_pay;
	}

	public void calculateSalary()
	{
		double pf = this.basic_pay*(0.12);
		this.salary = this.basic_pay - pf;
	}
	/**
	 * used to set salary of an employee
	 * @param salary
	 */
	public void setEmployee_salary(int salary)
	{
		this.salary = salary;
	}
	public double getEmployee_salary()
	{
		return this.salary;
	}
}
