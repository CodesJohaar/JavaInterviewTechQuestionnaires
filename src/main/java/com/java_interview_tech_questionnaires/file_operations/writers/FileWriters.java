package com.java_interview_tech_questionnaires.file_operations.writers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class FileWriters extends AbstractClass {
	public static void main(String[] args) throws IOException {
		File filePath = new File(directory);
		boolean mkdirs = filePath.mkdirs();
		try (FileWriter fileWriter = new FileWriter(directory + fileName, true);
		     FileWriter fileWriter1 = new FileWriter("", true);
		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			fileWriter.write("Hello World!!!!!----");
			System.out.println("Enter text (type 'exit' to quit):");
			String s;
			while (!(s = bufferedReader.readLine().trim()).equals("exit")) {
				fileWriter.write(s + "\n");
			}
		}
	}
}
