package com.employee.app;

public class Loan 
{
	/**
	 * Used to calculate the loan amount based on the Employee Object 
	 * @param e
	 * @return
	 */
	public double calculateLoanAmount(Employee e)
	{
		double loan = 0;
		if(e instanceof PermanentEmployee)
		{
		    loan = e.salary *(0.15) ;
			return loan;
		}
		
		else if(e instanceof TemporaryEmployee)
		{
		    loan = e.salary *(0.10);
			return loan;
		}
		else
		{
			return loan;
		}
		
	}

}
