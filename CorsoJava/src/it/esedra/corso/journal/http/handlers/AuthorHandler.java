package it.esedra.corso.journal.http.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.execeptions.HandleRequestException;
import it.esedra.corso.journal.service.AuthorService;

public class AuthorHandler extends Handler {
	
	public JsonObject handlePostRequest(HttpExchange httpExchange) throws HandleRequestException {
		Author author = null;
		
		try {
			InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String query = br.readLine();

			JsonReader reader = Json.createReader(new StringReader(query));
			JsonObject journalObject = reader.readObject();
			reader.close();
			
			author = AuthorService.update(journalObject);

		} catch (Exception e) {
			throw new HandleRequestException(e.getMessage(), e);
		}
		if(author == null) {
			throw new HandleRequestException("Insert Error.");
		} else {
			return JsonHelper.ok(author.toJson());
		}

	}

	
}
