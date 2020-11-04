package it.esedra.corso.journal.http.handlers;

import java.io.IOException;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonObject;

import com.sun.net.httpserver.HttpExchange;

public class HandlerHelper {
	/**
	 * Gestisce la Response in errore
	 * 
	 * @param t
	 * @param response
	 * @throws IOException
	 */
	protected static void responseFail(HttpExchange t, String response) throws IOException {
		t.sendResponseHeaders(500, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

	/**
	 * Gestisce la Response
	 * 
	 * @param t
	 * @param response
	 * @throws IOException
	 */
	protected static void response(HttpExchange t, String response) throws IOException {
		t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		t.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
		t.getResponseHeaders().add("Content-type", "plain/text");
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

	protected static JsonObject ok() {
		return Json.createObjectBuilder().add("status", "ok").add("message", "").add("data", "").build();
	}

	protected static JsonObject ko(String message) {
		return Json.createObjectBuilder().add("status", "ko").add("message", message).add("data", "").build();
	}

}
