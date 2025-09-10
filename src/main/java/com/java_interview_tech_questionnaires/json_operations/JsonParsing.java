package com.java_interview_tech_questionnaires.json_operations;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java_interview_tech_questionnaires.AbstractClass;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class JsonParsing extends AbstractClass {
	public static void main(String[] args) throws JsonProcessingException {
		String jsonData = "{ \"id\": 1, \"name\": \"Ravi\", \"active\": true }";
		ObjectMapper objMapper = new ObjectMapper();
		Map<String, String> stringStringMap = objMapper.readValue(jsonData, Map.class);
		print(stringStringMap);
		TreeMap<String, String> stringStringTreeMap = new TreeMap<>(stringStringMap);
		print(stringStringTreeMap);
	}
}
