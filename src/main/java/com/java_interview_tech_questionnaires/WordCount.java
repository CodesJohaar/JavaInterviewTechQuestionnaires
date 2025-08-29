package com.java_interview_tech_questionnaires;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 04, 2025
 */
public class WordCount {
	public static void main(String[] args) {
		String str = "Java spring boot java spring";
		Map<Object, Long> collect = Arrays.stream(str.split(" "))
				.map(String::toLowerCase)
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(collect);
		
	}
}
