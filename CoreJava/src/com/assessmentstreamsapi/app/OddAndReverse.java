package com.assessmentstreamsapi.app;

import java.util.Scanner;

class OddNumbersThread extends Thread {
    private int n;

    public OddNumbersThread(int n)
    {
        this.n = n;
     
    }

    
    public void run()
    {
        System.out.println( "Odd number thread started:");
        for (int i = 1; i<=this.n;i++) 
        {
            if(i%2 != 0 )
            {
            	System.out.println(i);
            }
        }
        System.out.println("Odd Number thread finished.");
    }
}

class ReverseThread extends Thread 
{
    private int n;

    public ReverseThread(int n) 
    {
        this.n = n;

    }

    
    public void run() 
    {
        System.out.println("Reverse thread started:");
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Reverse thread finished.....");
    }
}

public class OddAndReverse 
{
    public static void main(String[] args) 
    {
       
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the value of n : ");
    	int n = scan.nextInt();

        
        OddNumbersThread oddThread = new OddNumbersThread(n);
        ReverseThread reverseThread = new ReverseThread(n);

        
        oddThread.start();
        reverseThread.start();
        scan.close();

        

        System.out.println("Main thread finished.");
    }
}
