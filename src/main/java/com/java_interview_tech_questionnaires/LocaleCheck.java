package com.java_interview_tech_questionnaires;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author RavikantS on Sept 08, 2025
 */
public class LocaleCheck {
	public static void main(String[] args) {
//		Set<String> supportedCountries = new HashSet<>();
//		for (Locale locale : Locale.getAvailableLocales()) {
//			supportedCountries.add(locale.getCountry());
//		}
//
//		String[] allIsoCountries = Locale.getISOCountries();
//		for (String country : allIsoCountries) {
//			if (!supportedCountries.contains(country)) {
//				System.out.println(country);
//			}
//		}
		
		String s = "Shut up";
		Locale locale = new Locale("hi", "IN");
		MessageFormat messageFormat = new MessageFormat(s);
		messageFormat.setLocale(locale);
		String format = messageFormat.format(s);
		System.out.println(format);
	}
	
	
}
