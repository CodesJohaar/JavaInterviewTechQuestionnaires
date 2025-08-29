package com.java_interview_tech_questionnaires;

import java.util.Comparator;

/**
 * @author RavikantS on Aug 05, 2025
 */
public class CustomComparator {
	
	public static void main(String[] args) {
		Comparator<Employee> employeeComparator = Comparator.comparing(Employee::salary);
		
		
		Comparator<String> com = String::compareTo;
	}
}
