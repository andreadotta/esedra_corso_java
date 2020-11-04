package it.esedra.corso.journal.http.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.sql.Connection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.UserBuilder;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.dao.UserDao;
import it.esedra.corso.journal.db.JournalDbConnect;

public class UserHandler implements HttpHandler {
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
		// return
		// httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];Print

		try {
			InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String query = br.readLine();

			JsonReader reader = Json.createReader(new StringReader(query));
			JsonObject userObject = reader.readObject();
			reader.close();

			Connection connection = JournalDbConnect.connect();
			User user = new UserBuilder().setName(userObject.getString("name"))
					.setSurname(userObject.getString("surname")).setEmail(userObject.getString("email"))
					.setPassword(userObject.getString("password")).setRegistration(userObject.getString("registration"))
					.build();
			
			UserDao userDao = new UserDao(user);
			userDao.setConnection(connection);
			
			user = userDao.update();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void handlePutRequest(HttpExchange httpExchange) {
		// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
	}

	private void handleDeleteRequest(HttpExchange httpExchange) {
		// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
	}
}
