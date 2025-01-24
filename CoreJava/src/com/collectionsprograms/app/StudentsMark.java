package com.collectionsprograms.app;
import java.util.*;

public class StudentsMark {
	static void pushintoStack(HashMap<String, Integer> students,Stack<String> stack) {
		for (Map.Entry<String,Integer> set :students.entrySet()) {
			if(set.getValue() > 75)
				stack.push(set.getKey());
		}
	}
	static void popAndDisplay(HashMap<String, Integer> students,Stack<String> stack) {
		System.out.println("Students scored greater than 75 are: ");
		Iterator<String> value = stack.iterator();
		while(value.hasNext()) {
			String name = stack.pop();
			System.out.println("\tStudent Name:"+ name+" \tMark Scored:"+students.get(name)); 
		}
	}
	public static void main(String[] args) {
		HashMap<String, Integer> students = new HashMap<String, Integer>();
		Stack<String> s = new Stack<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of student details: ");
		int loop = sc.nextInt();
		sc.nextLine();
		
		for(int i=1;i<=loop;i++) {
			System.out.println("Enter the name of the Student: ");
			String name = sc.nextLine();
			System.out.println("Enter the mark of "+name+": ");
			int mark = sc.nextInt();
			sc.nextLine();
			students.put(name, mark);
		}
		StudentsMark.pushintoStack(students, s);
		StudentsMark.popAndDisplay(students, s);
		sc.close();
		
	}
}
