package com.java_interview_tech_questionnaires;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 04, 2025
 */
public class CharacterCount {
	public static void main(String[] args) {
		String str = "Raavii";
		Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(character -> character, Collectors.counting()));
		System.out.println(collect);
	}
}
