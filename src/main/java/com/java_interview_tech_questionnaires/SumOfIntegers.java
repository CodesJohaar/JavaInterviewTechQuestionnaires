package com.java_interview_tech_questionnaires;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 05, 2025
 */
public class SumOfIntegers {
	
	
	public static void main(String[] args) {
		int sum = List.of(2, 5, 2, 8, 6, 4, 9).stream().mapToInt(num -> num).sum();
		System.out.println("Sum of Integers : " + sum);
	}
}
