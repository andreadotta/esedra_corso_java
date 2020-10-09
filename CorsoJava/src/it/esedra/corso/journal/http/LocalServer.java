package it.esedra.corso.journal.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.function.Consumer;

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

			switch (t.getRequestMethod()) {
			case "GET": {
				this.handleGetRequest(t);
				response(t);
			}
			case "POST": {
				this.handlePostRequest(t);
				response(t);
			}
			case "PUT": {
				this.handlePutRequest(t);
				response(t);
			}
			case "DELETE": {
				this.handleDeleteRequest(t);
				response(t);
			}
			default:
				responseFail(t);
			}

		}

		private void responseFail(HttpExchange t) throws IOException {
			String response = "Internal Error";
			t.sendResponseHeaders(500, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		private void response(HttpExchange t) throws IOException {
			String response = "This is the response";
			t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
			t.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
			t.getResponseHeaders().add("Content-type", "plain/text");
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		private void handleGetRequest(HttpExchange httpExchange) {
					//String queryString = httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}

		private void handlePostRequest(HttpExchange httpExchange) {
			// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}

		private void handlePutRequest(HttpExchange httpExchange) {
			// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}

		private void handleDeleteRequest(HttpExchange httpExchange) {
			// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}
	}

}
