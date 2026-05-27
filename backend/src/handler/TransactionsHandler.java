package handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dto.TransactionRecord;
import dto.TransactionRequest;
import service.AuthService;

public class TransactionsHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String response = "";
		
		if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {
		
		InputStream inputStream = exchange.getRequestBody();
		
		InputStreamReader reader = new InputStreamReader(inputStream);
		
		Gson gson = new Gson();
		
		TransactionRequest request = gson.fromJson(reader, TransactionRequest.class);
		
		AuthService authService = new AuthService();
		
		List<TransactionRecord> transactions = authService.getTransactions(request.getAccountNumber());
		
		response = gson.toJson(transactions);
		
	} else {
		response = "{\"message\": "+
				 "\"Invalid Request Method\"}";
	}
	
		exchange.sendResponseHeaders(200, response.length());
		
		OutputStream outputStream = exchange.getResponseBody();
		
		outputStream.write(response.getBytes());
		
		outputStream.close();
	
	}
}
