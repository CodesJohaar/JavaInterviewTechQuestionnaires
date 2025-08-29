package com.java_interview_tech_questionnaires;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author RavikantS on Aug 04, 2025
 */
public class StrRemoveDuplicateChar {
	public static void main(String[] args) {
		String str = "inheritance";
		StringBuilder sb = new StringBuilder();
		char[] charArray = str.toCharArray();
		for (Character c : charArray) {
			if (!sb.toString().contains(String.valueOf(c))) {
				sb.append(c);
			}
		}
		
		str.chars().mapToObj(c -> String.valueOf((char) c)).map(String::toLowerCase)
				.forEach(character -> {
					if (!sb.toString().contains(character)) {
						sb.append(character);
					}
				});
		AtomicReference<String> resultStr = new AtomicReference<>("");
		str.chars().mapToObj(c -> String.valueOf((char) c)).map(String::toLowerCase)
				.forEach(character -> {
					if (!resultStr.get().contains(character)) {
						resultStr.getAndUpdate(string -> string + character);
					}
				});
		System.out.println("From atomic : " + resultStr.get());
		System.out.println("Input String : " + str);
		System.out.println("Result String : " + sb);
	}
	
}
