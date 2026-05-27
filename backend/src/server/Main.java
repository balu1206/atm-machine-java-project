package server;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

import handler.BalanceHandler;
import handler.DepositHandler;
import handler.LoginHandler;
import handler.TransactionsHandler;
import handler.WithdrawHandler;

public class Main {

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.setExecutor(null);
		server.start();
		
		server.createContext("/login", new LoginHandler());

		server.createContext("/balance", new BalanceHandler());

		server.createContext("/withdraw", new WithdrawHandler());
		
		server.createContext("/deposit", new DepositHandler());
		
		server.createContext("/transactions", new TransactionsHandler());

		System.out.println("ATM Server started on port 8080");

	}

}
