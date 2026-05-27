package handler;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dto.WithdrawRequest;
import service.AuthService;
public class WithdrawHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		
		String response = "";
		
		if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {
			
			InputStream inputStream = exchange.getRequestBody();
			
			InputStreamReader reader = new InputStreamReader(inputStream);
			
			Gson gson = new Gson();
			
			WithdrawRequest withdrawRequest = gson.fromJson(reader, WithdrawRequest.class);
			
			AuthService authService = new AuthService();
			
			boolean success = authService.withdraw(withdrawRequest.getAccountNumber(),withdrawRequest.getAmount());
			
			double remainingBalance = authService.getBalance(withdrawRequest.getAccountNumber());
			
			if(success) {
				response = "{ \"status\": true, "+
							"\"message\": " +
							"\"withdrawl Successful\", "+
							"\"Remaining Balance \": "+
							remainingBalance +
							" }";
				
			} else {
				response = "{ \"status\": false, " +
							"\"message\": "+
							"\"Insufficient Balance\" }" ;
				
			}
		}else {
			response = "{ \"message\": "+
						"\"Invalid Request Method\" }";
		}
		
		exchange.sendResponseHeaders(200, response.length());
		
		OutputStream outputStream = exchange.getResponseBody();
		
		outputStream.write(response.getBytes());
		
		outputStream.close();
		
	}

}
