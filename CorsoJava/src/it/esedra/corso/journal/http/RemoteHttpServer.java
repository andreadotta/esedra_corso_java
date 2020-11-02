package it.esedra.corso.journal.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Scanner;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import it.esedra.corso.journal.http.handlers.AuthorHandler;
import it.esedra.corso.journal.http.handlers.ChapterHandler;
import it.esedra.corso.journal.http.handlers.ImageHandler;
import it.esedra.corso.journal.http.handlers.JournalHandler;
import it.esedra.corso.journal.http.handlers.ParagraphHandler;
import it.esedra.corso.journal.http.handlers.UserHandler;
import it.esedra.corso.journal.http.handlers.VideoHandler;


public class RemoteHttpServer {

	public static void main(String[] args) throws Exception {

		new RemoteHttpServer();
	}

	public RemoteHttpServer() throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/author", new AuthorHandler());
		server.createContext("/journal", new JournalHandler());	
		server.createContext("/image", new ImageHandler());	
		server.createContext("/user", new UserHandler());			
		server.createContext("/video", new VideoHandler());					
		server.createContext("/paragraph", new ParagraphHandler());
		server.createContext("/chapter", new ChapterHandler());
		
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
			String response = "";
			t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
			t.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
			t.getResponseHeaders().add("Content-type", "plain/text");
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		private void handleGetRequest(HttpExchange httpExchange) {
			// String queryString =
			// httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}

		private void handlePostRequest(HttpExchange httpExchange) throws IOException {
			// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];Print
			
			
			   			
			
		}

		private void handlePutRequest(HttpExchange httpExchange) {
			// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}

		private void handleDeleteRequest(HttpExchange httpExchange) {
			// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}
	}

	private static String streamToString(InputStream inputStream) {
		String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
		return text;
	}

	public static String jsonGetRequest(String urlQueryString) {
		String json = null;
		try {
			URL url = new URL(urlQueryString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}

}
