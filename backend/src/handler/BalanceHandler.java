package handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dto.BalanceRequest;
import service.AuthService;

public class BalanceHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		
		String response = "";
		
		if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {
			InputStream inputStream = exchange.getRequestBody();
			
			InputStreamReader reader = new InputStreamReader(inputStream);
			
			Gson gson = new Gson();
			
			BalanceRequest balanceRequest = gson.fromJson(reader, BalanceRequest.class);
			
			AuthService authService  = new AuthService();
			
			double balance = authService.getBalance(balanceRequest.getAccountNumber());
			
			response = "{ \"status\": true," +
						"\"balance\": " +
						balance +
						" }";
			
		}else {
			response = "{ \"message\": " +
					"\"Invalid Request Method\" }";
		}
		
		exchange.sendResponseHeaders(200, response.length());
		
		OutputStream outputStream = exchange.getResponseBody();
		
		outputStream.write(response.getBytes());
		
		outputStream.close();
		
	}
	
}
