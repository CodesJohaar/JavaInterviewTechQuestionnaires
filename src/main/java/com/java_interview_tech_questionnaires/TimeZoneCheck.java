package com.java_interview_tech_questionnaires;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author RavikantS on Aug 25, 2025
 */
public class TimeZoneCheck {
	public static void main(String[] args) throws ParseException {
		Instant nowUtc = Instant.now();  // always UTC
		System.out.println("UTC Instant: " + nowUtc);
		
		Date legacyDate = Date.from(nowUtc);
		System.out.println("Legacy Date in UTC: " + legacyDate);
		
		Date utc = Date.from(LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant());
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));
		Date time = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
//		CronExpression cronExpression = new CronExpression("0 0 0 30 * ? *");
//		cronExpression.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
//		boolean satisfiedBy = cronExpression.isSatisfiedBy(utc);
//		System.out.println(cronExpression.isSatisfiedBy(time));
	}
}
