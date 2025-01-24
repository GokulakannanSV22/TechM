package com.collectionsprograms.app;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class StudentDetails
{
	
	private int student_rollno;
	private String student_name;
	private String student_department;
	
	
	public StudentDetails(int student_rollno,String student_name,String student_department)
	{
		this.student_rollno = student_rollno;
		this.student_name = student_name;
		this.student_department = student_department;
	}
	

	public String toString()
	{
		return "Roll.No : "+student_rollno +"\nStudent Name : "+student_name+"\nStudent Department : "+student_department;
	}
    public static void main(String [] args)
    {
    	Scanner scan = new Scanner(System.in);
    	LinkedList<StudentDetails> arr = new LinkedList<StudentDetails>();
    	
    	while(true)
    	{
    		System.out.println("1.AddStudent\n2.RemoveStudent\n3.Display");
    		int choice = scan.nextInt();
    		
    		switch(choice)
    		{
    		 case 1:
    			System.out.println("Enter the Student Roll Number : ");
    			int stud_rollno = scan.nextInt();
    			scan.nextLine();
    			System.out.println("Enter the Student Name : ");
    			String stud_name = scan.nextLine();
    			System.out.println("Enter the Student Department : ");
    			String stud_dept = scan.nextLine();
    			
    			StudentDetails s = new StudentDetails(stud_rollno,stud_name,stud_dept);
    			arr.add(s);
    			
    			
    			break;
    		 case 2:
    			 System.out.println("Enter Student Roll.no to Delete : ");
    			 int stud_rollnum = scan.nextInt();
    			 
    			 for(StudentDetails o:arr)
    			 {
    				 if(o.student_rollno == stud_rollnum)
    				 {
    					 arr.remove(o);
    				 }
    			 }
    			
    		
    		
    		}
    		
    	}
	    
    }
}
