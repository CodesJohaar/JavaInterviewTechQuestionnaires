package com.java_interview_tech_questionnaires.file_operations.writers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class UsingBufferedWriterClass extends AbstractClass {
	public static void main(String[] args) {
		File fileDirectory = new File(directory);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
		}
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(directory + fileName, true));
		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String s;
			while (!(s = bufferedReader.readLine()).equals("exit")) {
				bufferedWriter.write(s);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			printErr("Error while writing data into file", e.getMessage());
		}
	}
}
