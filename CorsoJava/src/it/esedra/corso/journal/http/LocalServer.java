package it.esedra.corso.journal.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class LocalServer {

	public static void main(String[] args) throws Exception {

		new LocalServer();
	}

	public LocalServer() throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/author", new MyHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
	}

	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {

			if (t.getRequestMethod().equals("POST")) {
				
			}
			
			String response = "This is the response";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		private String handleGetRequest(HttpExchange httpExchange) {
			return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}
	}

}
