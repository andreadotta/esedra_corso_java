package it.esedra.corso.journal.http.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Connection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.ChapterBuilder;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.HandleRequestException;
import it.esedra.corso.journal.service.JournalService;

public class ChapterHandler extends Handler {

	public JsonObject handleGetRequest(HttpExchange httpExchange) throws HandleRequestException {
		throw new HandleRequestException("Not Implemented Yet.");
	}

	public JsonObject handlePostRequest(HttpExchange httpExchange) throws HandleRequestException {

		Chapter chapter = null;
		
		try {
			InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String query = br.readLine();

			JsonReader reader = Json.createReader(new StringReader(query));
			JsonObject chapterObject = reader.readObject();
			reader.close();
			
			chapter = ChaptereService.update(chapterObject);

		} catch (Exception e) {
			throw new HandleRequestException(e.getMessage(), e);
		}
		
		if(chapter == null) {
			throw new HandleRequestException("Insert Error.");
		} else {
			return JsonHelper.ok(chapter.toJson());
		}
		

	}

	public JsonObject handlePutRequest(HttpExchange httpExchange) throws HandleRequestException {
		throw new HandleRequestException("Not Implemented Yet.");
	}

	public JsonObject handleDeleteRequest(HttpExchange httpExchange) throws HandleRequestException {
		throw new HandleRequestException("Not Implemented Yet.");
	}
}
