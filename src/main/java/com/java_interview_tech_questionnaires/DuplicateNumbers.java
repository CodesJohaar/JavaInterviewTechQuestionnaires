package com.java_interview_tech_questionnaires;

import kotlin.Function;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 06, 2025
 */
public class DuplicateNumbers {
	public static void main(String[] args) {
		int[] arr = {2, 5, 2, 1, 5, 3, 3};
		Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
		List<Integer> list = collect.entrySet().stream().filter(map -> map.getValue() > 1)
				.map(Map.Entry::getKey).toList();
		list.forEach(num -> System.out.println("Streams Duplicates : " + num));
		
		Map<Integer, Integer> occurrences = new HashMap<>();
//		Set<Integer> integers = occurrences.keySet();
//		Collection<Integer> values = occurrences.values();
//		Set<Map.Entry<Integer, Integer>> entries = occurrences.entrySet();
		
		for (int i : arr) {
			Integer i1 = occurrences.computeIfPresent(i, (k, v) -> ++v);
			Integer i2 = occurrences.putIfAbsent(i, 1);
			Integer i3 = occurrences.computeIfAbsent(i, k -> 0);

//			if (occurrences.containsKey(i)) {
//				Integer i1 = occurrences.get(i);
//				occurrences.put(i, ++i1);
//			} else {
//				occurrences.put(i, 1);
//			}
		}
		
		System.out.println(occurrences);
		
		occurrences.entrySet().stream().filter(value -> value.getValue() > 1)
				.forEach(map -> System.out.println("Duplicates : " + map.getKey()));
	}
}
