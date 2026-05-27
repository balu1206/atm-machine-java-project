package handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dto.DepositRequest;
import service.AuthService;

public class DepositHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		
		String response = "";
		
		if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {
			
			InputStream inputStream = exchange.getRequestBody();
			
			InputStreamReader reader = new InputStreamReader(inputStream);
			
			Gson gson = new Gson();
			
			DepositRequest depositRequest = gson.fromJson(reader, DepositRequest.class);
			
			AuthService authService = new AuthService();
			
			boolean success = authService.deposite(depositRequest.getAccountNumber(),depositRequest.getAmount() );
			
			double updatedBalance = authService.getBalance(depositRequest.getAccountNumber());
			
			if(success) {
				response = "{ \"status\": true, " +
                        "\"message\": " +
                        "\"Deposit Successful\", " +
                        "\"remainingBalance\": " +
                        updatedBalance +
                        " }";
			} else {
				response = "{ \"status\": false, " +
                        "\"message\": " +
                        "\"Deposit Failed\" }";
			}
			
		}else {
			response =
                    "{ \"message\": " +
                    "\"Invalid Request Method\" }";
		}
		
		exchange.sendResponseHeaders(200, response.length());
		
		OutputStream outputStream = exchange.getResponseBody();
		
		outputStream.write(response.getBytes());
		
		outputStream.close();
		
	}
	
}
