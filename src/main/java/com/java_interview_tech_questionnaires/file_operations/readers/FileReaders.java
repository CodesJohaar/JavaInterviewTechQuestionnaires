package com.java_interview_tech_questionnaires.file_operations.readers;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author RavikantS on Sept 05, 2025
 */
public class FileReaders extends AbstractClass {
	public static void main(String[] args) {
		String filePath = "/Users/ravikants/Desktop/";
		String fileName = "Bulk_Ach_CSV_Template.csv";
		Path path = Path.of(filePath, fileName);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath + fileName));
		     Scanner scanner = new Scanner(path);
		     Stream<String> lines = Files.lines(path)) {
			System.out.println("BufferReader");
			String s = bufferedReader.readLine();
			System.out.println(s);
			bufferedReader.lines().forEach(System.out::println);
			System.out.println("Scanner");
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			System.out.println("Files.readLines()");
			List<String> strings = Files.readAllLines(path);
			strings.forEach(System.out::println);
			
			System.out.println("Files.lines()");
			lines.forEach(System.out::println);
		} catch (Exception e) {
			System.err.println("Exception occurred : " + e.getMessage());
		}
		
	}
	
	private static void readFile(String path) {
//		NOTE: Paths is a UTILITY CLASS introduced in JAVA 1.7
		Path appendFilePaths = Paths.get(path);
		Path dynamicPath = Paths.get(path, path, path);
//		NOTE: Path is an INTERFACE introduced in JAVA 11, with static method of(), and uses Paths.get() internally for backward compatibility.
		Path filePath = Path.of(path);
		Path dynamicFilePath = Path.of(path, path, path, path);
		try (Scanner newFileOutOfPath = new Scanner(new File(path));
		     Scanner scnFileOutOfPath = new Scanner(filePath);
		     BufferedReader bR = new BufferedReader(new FileReader(path));
		     Stream<String> lines = Files.lines(filePath)
			 ) {
			List<String> strings = Files.readAllLines(filePath);
			String s = Files.readString(appendFilePaths);
			
			byte[] bytes = Files.readAllBytes(filePath);
			
		} catch (IOException err) {
			printErr("Error while reading file", err.getMessage());
		}
	}
}
