package com.java_interview_tech_questionnaires.file_operations.readers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class UsingScannerClass extends AbstractClass {
	public static void main(String[] args) {
		print("Reading file using Scanner class");
		try (Scanner scanner = new Scanner(new File(directory + fileName));
		     // NOTE: Here below is the Path object argument.
		     Scanner filePathScn = new Scanner(filePath)) {
			while (scanner.hasNextLine()) {
				print(scanner.nextLine());
			}
			while (filePathScn.hasNextLine()) {
				print(filePathScn.nextLine());
			}
		} catch (IOException e) {
			printErr("Error while processing file", e.getMessage());
		}
	}
}
