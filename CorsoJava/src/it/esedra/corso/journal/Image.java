package it.esedra.corso.journal;

import javax.json.Json;
import javax.json.JsonObject;

import it.esedra.corso.collections.interfaces.DataObjectInterface;

/**
 * Questa classe rappresenta una immagine presente nel capitolo
 * 
 * @author Nayem
 *
 */
public class Image extends MultimediaResource implements DataObjectInterface  {

	public Image(int id, String src, String name) {
		super(id, src, name);

	}
	
public JsonObject toJson() {
		
		return Json.createObjectBuilder()
				.add("id", super.getId())
				.add("src", super.getSrc())
				.add("name", super.getName()).build();
	}

}
