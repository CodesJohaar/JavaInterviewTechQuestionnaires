package com.java_interview_tech_questionnaires.hacker_rank;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author RavikantS on Sept 04, 2025
 */
public class ContainerAndInventoryCount extends AbstractClass {
//  NOTE: Inputs for the task is expected as below.
//        Input 1 : A List containing List of Integers
//	NOTE: Input will have only '*' and '|'.
//	      Where '*' represents a product and '|' represents start and end of container.
//	      Example: |***| -> This is having 1 container and 3 products in it.
//	               *|**|*|* -> This is having 2 containers and 2 + 1 products.
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int num = scn.nextInt();
			int inputLength = scn.nextInt();
			List<List<Integer>> indexes = new ArrayList<>();
			while (num-- > 0) {
				int tempCount = inputLength;
				List<Integer> index = new ArrayList<>();
				while (tempCount-- > 0) {
					index.add(scn.nextInt());
				}
				indexes.add(index);
			}
			scn.nextLine();
			String input = scn.nextLine();
			long s = System.currentTimeMillis();
			print("Product count", process(indexes.getFirst(), indexes.getLast(), input));
			print("Time taken", System.currentTimeMillis() - s);
		}
	}
	
	private static List<Integer> process(List<Integer> startIndexes, List<Integer> endIndexes, String input) {
		print("Start", startIndexes);
		print("End", endIndexes);
		List<Integer> response = new ArrayList<>();
		IntStream.range(0, startIndexes.size()).boxed().forEach(i -> {
			String operatingStr = input.substring(startIndexes.get(i), endIndexes.get(i));
			print("Operating String", operatingStr);
			// NOTE: Handles edge cases like : *** strings.
			if (operatingStr.contains("|")) {
				operatingStr = operatingStr.substring(operatingStr.indexOf("|"), operatingStr.lastIndexOf("|"));
				response.add(operatingStr.length() - operatingStr.replace("*", "").length());
			} else {
				response.add(0);
			}
		});
		return response;
//			int pipeCount = operatingStr.length() - operatingStr.replace("|", "").length();
//			if (pipeCount < 2) {
//				response.add(0);
//			} else if (operatingStr.startsWith("|") && operatingStr.endsWith("|")) {
//				response.add(operatingStr.length() - operatingStr.replace("*", "").length());
//			} else {
//				operatingStr = operatingStr.substring(operatingStr.indexOf("|"), operatingStr.lastIndexOf("|"));
//				while (operatingStr.startsWith("*")) {
//					operatingStr = operatingStr.substring(1);
//				}
//				while (operatingStr.endsWith("*")) {
//					operatingStr = operatingStr.substring(0, operatingStr.length() - 1);
//				}
//				response.add(operatingStr.length() - operatingStr.replace("*", "").length());
//			}
//		});
//		return response;
	}
}
