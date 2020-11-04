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
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.ParagraphBuilder;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.db.JournalDbConnect;

public class ParagraphHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {

		switch (t.getRequestMethod()) {
		case "GET": {
			this.handleGetRequest(t);

		}
		case "POST": {
			this.handlePostRequest(t);

		}
		case "PUT": {
			this.handlePutRequest(t);

		}
		case "DELETE": {
			this.handleDeleteRequest(t);

		}
		default:
			HandlerHelper.responseFail(t, "Invalid HTTP method");
		}

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
			JsonObject paragraphObject = reader.readObject();
			reader.close();

			Connection connection = JournalDbConnect.connect();
			Paragraph paragraph = new ParagraphBuilder().setText(paragraphObject.getString("text")).build();
			ParagraphDao paragraphDao = new ParagraphDao(paragraph);
			paragraphDao.setConnection(connection);

			paragraph = paragraphDao.update();
			
			HandlerHelper.response(httpExchange, HandlerHelper.ok().toString());

		} catch (Exception e) {
			
			e.printStackTrace();
			HandlerHelper.responseFail(httpExchange, HandlerHelper.ko(e.getMessage()).toString());	
		}

	}

	private void handlePutRequest(HttpExchange httpExchange) {
		// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
	}

	private void handleDeleteRequest(HttpExchange httpExchange) {
		// return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
	}
}
