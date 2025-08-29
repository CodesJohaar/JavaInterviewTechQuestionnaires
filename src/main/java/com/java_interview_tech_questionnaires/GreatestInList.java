package com.java_interview_tech_questionnaires;

import java.util.Comparator;
import java.util.List;

/**
 * @author RavikantS on Aug 04, 2025
 */
public class GreatestInList {
	public static void main(String[] args) {
		List<Integer> integers = List.of(10, 4, 15, 19, 3, 32);
		System.out.println("Max : " + integers.stream().max(Comparator.naturalOrder()));
		System.out.println("Min : " + integers.stream().min(Comparator.comparingInt(num -> num)).get());
	}
}
