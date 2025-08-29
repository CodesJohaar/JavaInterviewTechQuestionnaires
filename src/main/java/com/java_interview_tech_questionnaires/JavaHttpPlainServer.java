package com.my_portfolio;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 27, 2025
 */
public class Main {
	private static final Map<Integer, Object> data = new HashMap<>();
	private static final AtomicInteger counter = new AtomicInteger(1);
	enum RequestTypes {
		GET(1, "GET"),
		POST(2, "POST"),
		PATCH(3, "PATCH"),
		PUT(4, "PUT"),
		DELETE(5, "DELETE");
		private final Integer id;
		private final String requestType;
		
		RequestTypes(Integer id, String requestType) {
			this.id = id;
			this.requestType = requestType;
		}
		
		public static final Predicate<String> validateReqType = reqMethodName ->
				Arrays.stream(values()).anyMatch(reqTypes -> reqTypes.requestType.equalsIgnoreCase(reqMethodName));
		
		public static final Function<String, RequestTypes> getByType = reqType ->
				Arrays.stream(values()).filter(val -> val.requestType.equalsIgnoreCase(reqType)).findFirst().orElse(null);
	}
	
	public static void main(String[] args) throws IOException {
		int port = 9001;
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);
		httpServer.createContext("/api/v1/portfolio", exchange -> {
			String requestMethod = exchange.getRequestMethod();
			if (RequestTypes.validateReqType.test(requestMethod)) {
//				RequestTypes byType = RequestTypes.getByType.apply(requestMethod);
				switch (requestMethod) {
					case "GET" -> handleGetReq(exchange);
					case "POST" -> handlePostReq(exchange);
					case "PATCH" -> handlePatchReq(exchange);
					case "PUT" -> handlePutReq(exchange);
					case "DELETE" -> handleDeleteReq(exchange);
				}
			} else {
				sendResponse(exchange, "Invalid request!!!");
			}
			
		});
		httpServer.setExecutor(null); // By default, java configure an executor. Since we don't need it, setting it to null.
		httpServer.start();
		System.out.printf("Server started on %d port%n", port);
	}
	
	private static void handleDeleteReq(HttpExchange exchange) throws IOException {
		String toDelete = new String(exchange.getRequestBody().readAllBytes());
		data.remove(Integer.parseInt(toDelete));
		sendResponse(exchange, "Deleted successfully!!!");
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
		     PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
		     ResultSet resultSet = preparedStatement.executeQuery()) {
			Class.forName("org.postgresql.Driver");
			while (resultSet.next()) {
				int anInt = resultSet.getInt(0);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void handlePutReq(HttpExchange exchange) throws IOException {
		if (exchange.getRequestBody() instanceof Map<?, ?> request) {
			Object id = request.get("id");
			data.computeIfPresent(Integer.parseInt(id.toString()), (k, v) -> request.get("updateData"));
			sendResponse(exchange, "Record updated successfully!!!");
			return;
		}
		sendResponse(exchange, "Invalid request!!!");
	}
	
	private static void handlePatchReq(HttpExchange exchange) throws IOException {
		Arrays.stream(new String(exchange.getRequestBody().readAllBytes()).split("\n"))
				.map(data -> data.split(":", 2)).toList()
				.forEach(mapData -> data.computeIfPresent(Integer.valueOf(mapData[0]), (k, v) -> mapData[1]));
//		Integer toUpdateIndex = Integer.parseInt(split[0]);
//		String toUpdate = split[1];
//		data.computeIfPresent(toUpdateIndex, (k, v) -> toUpdate);
		sendResponse(exchange, "Record updated successfully!!!");


//		if (exchange.getRequestBody() instanceof Map<?, ?> request) {
//			Object id = request.get("id");
//			data.computeIfPresent(Integer.parseInt(id.toString()), (k, v) -> request.get("updateData"));
//			sendResponse(exchange, "Record updated successfully!!!");
//			return;
//		}
//		sendResponse(exchange, "Invalid request!!!");
	}
	
	private static void handlePostReq(HttpExchange exchange) throws IOException {
		String requestBody = new String(exchange.getRequestBody().readAllBytes());
		data.putIfAbsent(counter.getAndUpdate(i -> ++i), requestBody);
		sendResponse(exchange, "Created successfully!!!");
	}
	
	private static void handleGetReq(HttpExchange exchange) {
		if (data.size() <= 0) {
			data.put(counter.get(), "Hello from raw server");
			counter.getAndUpdate(i -> ++i);
		}
		String collect = data.entrySet().stream()
				.map(element -> element.getKey() + " : " + element.getValue())
				.collect(Collectors.joining("\n"));
		sendResponse(exchange, collect);
	}
	
	public static void sendResponse(HttpExchange exchange, String responseBody) {
		try (OutputStream os = exchange.getResponseBody()) {
			exchange.sendResponseHeaders(200, responseBody.getBytes().length);
			os.write(responseBody.getBytes());
		} catch (Exception e) {
			System.out.println("Error occurred while writing response!!!!!\n" + e.getMessage());
		}
	}
}