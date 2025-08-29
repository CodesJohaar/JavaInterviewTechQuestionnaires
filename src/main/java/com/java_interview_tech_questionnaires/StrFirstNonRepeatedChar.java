package com.java_interview_tech_questionnaires;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 05, 2025
 */
public class StrFirstNonRepeatedChar {
	public static void main(String[] args) {
		String str = "dhdaayhy";
		Map<String, Long> collect = str.chars().mapToObj(c -> String.valueOf((char) c))
				.filter(character -> !character.isBlank()).map(String::toLowerCase)
				.collect(Collectors.groupingBy(character -> character, Collectors.counting()));
		collect.entrySet().stream().filter(map -> map.getValue().equals(1L)).findFirst()
				.ifPresentOrElse(entry -> System.out.printf("First non repeating character is : %s \n", entry.getKey()),
						() -> System.out.println("No non-repeating character or, invalid input (empty String provided)."));
		collect.entrySet().stream().filter(val -> val.getValue().equals(1L))
				.forEach(entry -> System.out.printf("First non repeating character is : %s \n", entry.getKey()));
		
	}
}
