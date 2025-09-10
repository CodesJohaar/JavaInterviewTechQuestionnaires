package com.java_interview_tech_questionnaires.file_operations.readers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class UsingBufferedReader extends AbstractClass {
	public static void main(String[] args) {
		boolean exists = filePath.toFile().exists();
//		new File(new URI(filePath)).exists();
		if (!exists) {
			boolean mkdirs = new File(directory).mkdirs();
		}
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(directory + fileName))) {
			print("Reading all the lines \n");
			Stream<String> lines = bufferedReader.lines();
			lines.forEach(UsingBufferedReader::print);
			bufferedReader.close();
//			long skip = bufferedReader.skip(2); // To skip number of characters
			print("Reading single line \n");
			String s = bufferedReader.readLine();
			print(s);
		} catch (IOException e) {
			System.err.println("Error while reading the file: " + e.getMessage());
		}
	}
}
