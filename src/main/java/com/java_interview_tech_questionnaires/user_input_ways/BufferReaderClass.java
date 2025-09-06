package com.java_interview_tech_questionnaires.user_input_ways;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RavikantS on Sept 04, 2025
 */
public class BufferReaderClass extends AbstractClass {
	public static void main(String[] args) {
		// NOTE: This particular class is used to read near to infinite data from user.
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			byte[] bytes = System.in.readNBytes(5);
			print("Bytes using System.in", bytes);
			// NOTE: Reading a STATEMENT
			print("Enter a statement");
			String statement = bufferedReader.readLine();
			print("Statement", statement);
			// NOTE: Reading a CHARACTER
			print("Enter a character");
			int readMethod = bufferedReader.read();
			print("ASCII value of 1st input character is", readMethod);
		} catch (IOException ioExe) {
			printErr("IO Exception : " + ioExe.getMessage());
		}
	}
}
