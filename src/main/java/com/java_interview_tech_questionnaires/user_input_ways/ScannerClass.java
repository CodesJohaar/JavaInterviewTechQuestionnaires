package com.java_interview_tech_questionnaires.user_input_ways;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author RavikantS on Sept 04, 2025
 */
public class ScannerClass extends AbstractClass {
	public static void main(String[] args) {
		// NOTE: This is the very basic way to read the limited input from user.
		try (Scanner scanner = new Scanner(System.in)) {
			// NOTE: Reading an STRING STATEMENT
			print("Enter a Statement Input");
			String basicStringInput = scanner.nextLine();
			print("Statement", basicStringInput);
			// NOTE: Reading an WORD
			print("Enter a Single word Input");
			String singleWordInput = scanner.next();
			print("Single word", singleWordInput);
			// NOTE: Reading an CHARACTER
			print("Enter a Character Input");
			char basicCharInput = scanner.next().charAt(0);
			print("Character", basicCharInput);
			// NOTE: Reading an INTEGER
			print("Enter a Integer Input");
			int basicIntegerInput = scanner.nextInt();
			print("Integer", basicIntegerInput);
			// NOTE: Reading an LONG
			print("Enter a Long Input");
			long basicLongInput = scanner.nextLong();
			print("Long", basicLongInput);
			// NOTE: Reading an BIGINTEGER
			print("Enter a BigInteger Input");
			BigInteger basicBigIntegerInput = scanner.nextBigInteger();
			print("BigInteger", basicBigIntegerInput);
			// NOTE: Reading an FLOAT
			print("Enter a Float Input");
			float basicFloatInput = scanner.nextFloat();
			print("Float", basicFloatInput);
			// NOTE: Reading an DOUBLE
			print("Enter a Double Input");
			double basicDoubleInput = scanner.nextDouble();
			print("Double",basicDoubleInput);
			// NOTE: Reading an BIG DECIMAL
			print("Enter a BigDecimal Input");
			BigDecimal basicBigDecimalInput = scanner.nextBigDecimal();
			print("BigDecimal", basicBigDecimalInput);
			// NOTE: Reading an BOOLEAN
			print("Enter a Boolean Input");
			boolean booleanInput = scanner.nextBoolean();
			print("Boolean", booleanInput);
			// NOTE: Reading an SHORT
			print("Enter a Short Input");
			short shortInput = scanner.nextShort();
			print("Short", shortInput);
			// NOTE: Reading an BYTE
			print("Enter a Byte Input");
			byte byteInput = scanner.nextByte();
			print("Byte", byteInput);
		}
	}
}
