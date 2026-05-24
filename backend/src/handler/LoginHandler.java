package handler;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dto.LoginRequest;
import service.AuthService;
public class LoginHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String response = "";
		
		if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {
			
			InputStream inputStream = exchange.getRequestBody();
			InputStreamReader reader = new InputStreamReader(inputStream);
			
			Gson gson = new Gson();
			
			LoginRequest loginRequest = gson.fromJson(reader, LoginRequest.class);
			
			
			AuthService authService = new AuthService();
			
			boolean isValid = authService.login(
                    loginRequest.getAccountNumber(),
                    loginRequest.getPin()
            );
			
			if(isValid) {
				response = "{ \"status\" : true," +
							"\"message\":"
									+ "\"Login Successful\"}";
			} else {
				response = "{ \"status\":false, " +
							"\"message\":"+
							"\"Invalid Credentials\" }";
			} 
			
		}else {
			response = "{ \"message\":" +
					"\"Invalid Request Method\"}";
		
	}
		exchange.sendResponseHeaders(200, response.length());
		
		OutputStream outputStream = exchange.getResponseBody();
		
		outputStream.write(response.getBytes());
		
		outputStream.close();
		
		
	}
	
	
	
}
