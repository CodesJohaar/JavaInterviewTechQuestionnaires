package com.java_interview_tech_questionnaires.hacker_rank;

import java.util.Scanner;

/**
 * @author RavikantS on Sept 02, 2025
 */
public class ReadMultipleInputTypes {
	public static void main(String[] args) {
		Integer num;
		Double decimalNum;
		String str;
		try (Scanner scn = new Scanner(System.in)) {
			num = scn.nextInt();
			decimalNum = scn.nextDouble();
			scn.nextLine();
			str = scn.nextLine();
		}
		
		System.out.println("String: " + str);
		System.out.println("Double: " + decimalNum);
		System.out.println("Int: " + num);
	}
}
