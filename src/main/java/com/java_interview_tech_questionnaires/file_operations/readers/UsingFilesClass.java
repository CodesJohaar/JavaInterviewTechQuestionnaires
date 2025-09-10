package com.java_interview_tech_questionnaires.file_operations.readers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class UsingFilesClass extends AbstractClass {
	public static void main(String[] args) {
		print("Using Files class lines method");
		try (Stream<String> lines1 = Files.lines(filePath)) {
			lines1.forEach(UsingFilesClass::print);
			
			print("Using Files class readAllLines method");
			List<String> lines = Files.readAllLines(filePath);
			lines.forEach(UsingFilesClass::print);
			
			print("Using Files class readString method");
			String fileData = Files.readString(filePath);
			print(fileData);
		} catch (IOException e) {
			printErr("Error while reading file", e.getMessage());
		}
	}
}
