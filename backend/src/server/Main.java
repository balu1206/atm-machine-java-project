package server;

import java.net.InetSocketAddress;
import java.sql.Connection;

import com.sun.net.httpserver.HttpServer;

import database.DBConnection;
import handler.LoginHandler;

public class Main {

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(
					new InetSocketAddress(8080), 0
				);
		
		server.createContext(
					"/login",
					new LoginHandler()
				);
		
		server.setExecutor(null);
		server.start();
		
		System.out.println("ATM Server started on port 8080");
		
	}

}
