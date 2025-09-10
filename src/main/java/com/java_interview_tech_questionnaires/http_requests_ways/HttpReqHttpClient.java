package com.java_interview_tech_questionnaires.http_requests_ways;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class HttpReqHttpClient {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> send = httpClient.send(HttpRequest.newBuilder().uri(URI.create("")).build(), HttpResponse.BodyHandlers.ofString());
		
	}
}
