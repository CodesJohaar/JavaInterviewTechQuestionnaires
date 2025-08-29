package com.java_interview_tech_questionnaires;

import java.util.Arrays;
import java.util.List;

/**
 * @author RavikantS on Aug 06, 2025
 */
public class StrVowels {
	public static void main(String[] args) {
		String str = "Raviii Java yes hgvrtb";
		List<String> collect = Arrays.stream(str.split(" ")).filter(s -> s.matches(".*[AEIOUaeiou].*")).toList();
				//.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		System.out.println(collect);
	}
}
