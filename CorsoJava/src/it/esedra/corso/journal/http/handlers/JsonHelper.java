package it.esedra.corso.journal.http.handlers;

import javax.json.Json;
import javax.json.JsonObject;

public class JsonHelper<T> {
	
	protected static JsonObject ok(JsonObject data) {
		return Json.createObjectBuilder().add("status", "ok").add("message", "").add("data", data).build();
	}

	protected static JsonObject ko(String message) {
		return Json.createObjectBuilder().add("status", "ko").add("message", message).add("data", "").build();
	}

}
