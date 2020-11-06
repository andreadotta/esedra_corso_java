package it.esedra.corso.journal.http.handlers;

import java.io.IOException;

import javax.json.JsonObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import it.esedra.corso.journal.execeptions.HandleRequestException;

public abstract class Handler implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException {

		try {

			switch (t.getRequestMethod()) {
			case "GET": {
				this.handleGetRequest(t);
			}
			case "POST": {
				ResponseHelper.response(t, this.handlePostRequest(t).toString());
			}
			case "PUT": {
				this.handlePutRequest(t);
			}
			case "DELETE": {
				this.handleDeleteRequest(t);
			}
			default:
				ResponseHelper.responseFail(t, "Invalid HTTP method");
			}

		} catch (HandleRequestException e) {
			ResponseHelper.responseFail(t, e.getMessage());
		}

	}
	
	public JsonObject handleGetRequest(HttpExchange httpExchange) throws HandleRequestException {
		return null;
	}

	public JsonObject handlePostRequest(HttpExchange httpExchange) throws HandleRequestException {
		return null;
	}

	public  JsonObject handlePutRequest(HttpExchange httpExchange) throws HandleRequestException {
		return null;
	}

	public  JsonObject handleDeleteRequest(HttpExchange httpExchange) throws HandleRequestException {
		return null;
	}

}
