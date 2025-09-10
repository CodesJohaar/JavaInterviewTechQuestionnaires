package com.java_interview_tech_questionnaires.file_operations.writers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class UsingFilesClass extends AbstractClass {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> inputData = new ArrayList<>();
			while (scanner.hasNextLine()) {
				inputData.add(scanner.nextLine());
			}
			Files.writeString(filePath, String.join("\n", inputData));
		} catch (IOException e) {
			printErr("Error while writing data", e.getMessage());
		}
	}
}
