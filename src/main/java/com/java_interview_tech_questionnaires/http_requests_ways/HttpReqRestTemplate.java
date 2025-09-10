package com.java_interview_tech_questionnaires.http_requests_ways;

import com.java_interview_tech_questionnaires.Child;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class HttpReqRestTemplate {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String forObject = restTemplate.getForObject("", String.class);
		ResponseEntity<Child> forEntity = restTemplate.getForEntity("", Child.class);
	}
}
