package com.java_interview_tech_questionnaires;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 05, 2025
 */
public class StrReverse {
	public static void main(String[] args) {
		String str = "JavaCode";
		// Using String Builder
		String string1 = new StringBuilder(str).reverse().toString();
		System.out.println(string1);
		// Using Streams API
		String string = str.chars().mapToObj(c -> String.valueOf((char) c)).collect(
				Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return list.stream().map(String::valueOf).collect(Collectors.joining());
				}));
		String join = String.join("", str.chars().mapToObj(c -> String.valueOf((char) c)).toList().reversed());
		String collect = str.chars().mapToObj(c -> String.valueOf((char) c)).toList().reversed()
				.stream().collect(Collectors.joining());
		System.out.println(join);
		
		System.out.println(collect);
		System.out.println(string);
		// Using traditional way
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		System.out.println(result);
		
//		str.chars()
//				.mapToObj(c -> (char) c) // Convert int stream to Character stream
//				.boxed() // Boxed Character objects for count
//				.skip(str.length() - 1) // Skip all characters except the last one
//				.limit(str.length()) // Limit to string length (effectively reverse the stream)
//				.filter(c -> str.chars().filter(ch -> ch == c.charValue()).count() == 1)
//				.findFirst()
//				.orElse((char) -1);
//
//		List<Character> chars = List.of('c', 'd', 'e', 'f', 'g', 'h', 'i', 'a', 'b', 'c', 'd', 'e', 'f', 'z', 'y', 'y');
//		Map<Character, Long> collect = chars.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
//		collect.forEach((k,v) -> System.out.print(k + ":" + v + " "));
//
//		String statement = "Hello Java World C3 1001 String boolean";
//		Set<Character> res = Set.of('a', 'e', 'i', 'o', 'u');
//		List<String> vowelWords = Arrays.stream(statement.split(" ")).filter(item -> item.matches(".*[AEIOUaeiou].*")).toList();
//		System.out.println("\nVowel words: ");
//		vowelWords.forEach(System.out::println);
//
//		Map<Character, Long> lettersCountInString = statement.replace(" ", "").chars()
//				.mapToObj(item -> (char) item).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
//		lettersCountInString.forEach((k, v) -> System.out.print(k + ":" + v + " "));
//
//		List<String> nonVowelWords = Arrays.stream(statement.split(" ")).filter(item -> !item.matches(".*[AEIOUaeiou].*")).toList();
//		System.out.println("\nNon Vowel words: ");
//		nonVowelWords.forEach(System.out::println);
//
//		List<Integer> integers = List.of(10, 2, 30, 41, 15, 69, 17, 88);
//
//		Integer min = integers.stream().min(Comparator.naturalOrder()).get();
//		Integer min = integers.stream().min(Comparator.reverseOrder()).get();
//
//		List<Integer> minimumThree = integers.stream().sorted().limit(3).toList();
//		System.out.println("Minimum 3 values: ");
//		minimumThree.forEach(System.out::println);
//
//		List<Integer> limit = integers.stream().sorted().skip(integers.size() - 3).toList();
//		System.out.println("Maximum 3 values: ");
//		limit.forEach(System.out::println);
	}
}
