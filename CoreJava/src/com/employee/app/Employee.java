package com.employee.app;

public abstract class Employee
{
	
	
protected int employee_id;
protected String employee_name;
protected double salary;
//Default constructor if the user does not calls the parameterized constructor
public Employee()
{
	
}
/**
 * parameterized constructor used to initialize employee attributes
 * @param employee_id
 * @param employee_name
 */
public Employee(int employee_id,String employee_name)
{
	this.employee_id = employee_id;
	this.employee_name = employee_name;
}

/**
 * used to set employee attributes
 * @param employee_id
 * @param employee_name
 */
public void setEmployee_details(int employee_id , String employee_name)
{
	this.employee_id = employee_id;
	this.employee_name = employee_name;
}
public int getEmployee_id()
{
	return this.employee_id;
}
public String getEmployee_name()
{
	return this.employee_name;
}

public abstract void calculateSalary(); 

public static void main(String [] args)
{
	PermanentEmployee e1 = new PermanentEmployee(001,"Monk",45000);
	TemporaryEmployee e2 = new TemporaryEmployee(002,"gokulakannan",4,680);
	Loan l1 = new Loan();
	System.out.println("Employee ID:");
	System.out.println(e1.getEmployee_id());
	System.out.println("Employee Name:");
	System.out.println(e1.getEmployee_name());
	
	e1.calculateSalary();
	System.out.println("Employee Salary:");
	System.out.println(e1.getEmployee_salary());
	System.out.println("Employee Loan : ");
	System.out.println(l1.calculateLoanAmount(e1));
	

	System.out.println("Employee ID:");
	System.out.println(e2.getEmployee_id());
	System.out.println("Employee Name:");
	System.out.println(e2.getEmployee_name());
	
	e2.calculateSalary();
	System.out.println("Employee Salary:");
	System.out.println(e2.getEmployee_salary());
	System.out.println("Employee Loan : ");
	System.out.println(l1.calculateLoanAmount(e2));
}
}
