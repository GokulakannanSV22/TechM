package com.Assignment4.app;
import java.util.Scanner;
public class MyCalculator
{
	
    void power (int n,int p) throws Exception
	{
		if(n<0 || p<0)
		{
			throw new Exception("N or P should not be negative...");
		}
		else if(n==0 && p==0)
		{
		   
			throw new Exception("N or P should not be Zero....");
		}
		else
		{
			System.out.println("The value is : "+(long)Math.pow(n, p));
		}
	}
	
public static void main(String [] args) throws Exception
{
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter n:");
	int n = scan.nextInt();
	System.out.println("Enter p:");
	int p = scan.nextInt();
	
	MyCalculator calc = new MyCalculator();
	try
	{
		calc.power(n,p);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	finally
	{
		System.out.println("Program Terminated....");
	}
	scan.close();
	
}
}
