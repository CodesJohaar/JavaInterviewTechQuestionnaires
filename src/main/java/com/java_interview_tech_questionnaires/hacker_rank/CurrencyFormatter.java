package com.java_interview_tech_questionnaires.hacker_rank;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author RavikantS on Sept 04, 2025
 */
public class CurrencyFormatter extends AbstractClass {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			print("Enter a amount");
			double amount = scn.nextDouble();
			format(amount, Locale.US);
			// NOTE: Since Locale doesn't have INDIA, we are manually creating the object by providing language and country short code
			format(amount, Locale.of("en", "IN"));
			format(amount, Locale.CHINA);
			format(amount, Locale.FRANCE);
		}
	}
	
	private static void format(double amt, Locale locale) {
		NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
		String formattedAmt;
		if (locale.getDisplayCountry().equalsIgnoreCase("INDIA") && currencyInstance instanceof DecimalFormat df) {
			// NOTE: By default will get the Rupees symbol, but here, the requirement is to get 'Rs.' instead of symbol.
			//       Therefore, manually setting it up.
			DecimalFormatSymbols decimalFormatSymbols = df.getDecimalFormatSymbols();
			decimalFormatSymbols.setCurrencySymbol("Rs.");
			df.setDecimalFormatSymbols(decimalFormatSymbols);
			formattedAmt = df.format(amt);
		} else {
			formattedAmt = currencyInstance.format(amt);
		}
		print(locale.getDisplayCountry(), formattedAmt);
	}
}
