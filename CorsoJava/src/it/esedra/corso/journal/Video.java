package it.esedra.corso.journal;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Questa classe è un video presente nel capitolo
 * 
 *
 */
public class Video extends MultimediaResource {

	private final String title;

	public Video(int id, String src, String name, String title) {
		super(id, src, name);
		this.title = title;

	}

	public String getTitle() {
		return title;
	}
	
	public JsonObject toJson() {
		
		return Json.createObjectBuilder()
				.add("id", super.getId())
				.add("src", super.getSrc())
				.add("name", super.getName())
				.add("title", this.title).build();
	}

}
