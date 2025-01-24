package com.streamapiprograms.app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OnlineCoursePlatform 
{
	
	private String title;
	private String instructor;
	private int duration;
	private double rating;

	public OnlineCoursePlatform(String title , String instructor , int duration , double rating)
	{
		this.duration = duration;
		this.instructor = instructor;
		this.title = title;
		this.rating = rating;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public static void main(String [] args)
	{
		List<OnlineCoursePlatform> course_list = Arrays.asList(
				new OnlineCoursePlatform("Java Programming", "Alice", 15, 4.5),
				new OnlineCoursePlatform("Python for Beginners", "Bob", 8, 4.0),
				new OnlineCoursePlatform("Web Development", "Charlie", 20, 4.8),
				new OnlineCoursePlatform("Data Science", "David", 12, 3.9));
		
		List<String> filter_course = course_list.stream()
				.filter(a->a.duration>10).map(a-> a.getTitle()+"("+a.getDuration()+"hours)")
				.collect(Collectors.toList());
		
		OnlineCoursePlatform longest = course_list.stream()
				.max(Comparator.comparing(OnlineCoursePlatform::getDuration)).orElse(null);
		
		int total_duration = course_list.stream().mapToInt(a->a.getDuration()).sum();
		double avg_rating = course_list.stream().mapToDouble(a->a.rating).average().orElse(0);
		boolean all_courses = course_list.stream().allMatch(a -> a.rating > 4.0);
		System.out.print("Courses and title duration :");
		System.out.println(filter_course);
		System.out.print("Longest Course : ");
		System.out.println(longest.title);
		System.out.print("Total Duration : ");
		System.out.println(total_duration);
		System.out.print("Average Rating : ");
		System.out.println(avg_rating);
		System.out.print("All courses have a rating of 4.0 or higher : ");
		System.out.println(all_courses);
		
		
		
		
		
		
	}
	}
