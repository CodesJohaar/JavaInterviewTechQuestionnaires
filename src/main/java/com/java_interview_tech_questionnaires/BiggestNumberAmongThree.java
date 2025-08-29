package com.java_interview_tech_questionnaires;

/**
 * @author RavikantS on Aug 04, 2025
 */
public class BiggestNumberAmongThree {
	public static void main(String[] args) {
		Integer a = 30, b = 20, c = 50;
		if (a > b && a > c) {
			System.out.println("A : " + a + " is greatest");
		} else if (b > c) {
			System.out.println("B : " + b + " is greatest");
		} else {
			System.out.println("C : " + c + " is greatest");
		}
	}
}
