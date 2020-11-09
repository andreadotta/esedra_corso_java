
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
import it.esedra.corso.journal.execeptions.HandleRequestException;
import it.esedra.corso.journal.service.UserService;

public class UserHandler extends Handler {
	
	public JsonObject handleGetRequest(HttpExchange httpExchange) throws HandleRequestException {
		throw new HandleRequestException("Not Implemented Yet.");
	}

	public JsonObject handlePostRequest(HttpExchange httpExchange) throws HandleRequestException {

		User user = null;
		
		try {
			InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String query = br.readLine();

			JsonReader reader = Json.createReader(new StringReader(query));
			JsonObject userObject = reader.readObject();
			reader.close();

			user = UserService.update(userObject);

		} catch (Exception e) {
			throw new HandleRequestException(e.getMessage(), e);
		}
		
		if(user == null) {
			throw new HandleRequestException("Insert Error.");
		} else {
			return JsonHelper.ok(user.toJson());
		}

	}

	public JsonObject handlePutRequest(HttpExchange httpExchange) throws HandleRequestException {
		throw new HandleRequestException("Not Implemented Yet.");
	}

	public JsonObject handleDeleteRequest(HttpExchange httpExchange) throws HandleRequestException {
		throw new HandleRequestException("Not Implemented Yet.");
	}
	
}
