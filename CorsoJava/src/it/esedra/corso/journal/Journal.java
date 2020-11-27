package it.esedra.corso.journal;

import javax.json.Json;
import javax.json.JsonObject;

import it.esedra.corso.collections.interfaces.DataObjectInterface;
/**
 * Classe base dell'applicazione
 * 
 * @author bauhausk
 *
 */
public class Journal implements DataObjectInterface {

	private int id;
	private String name;
	private int idAuthor;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Journal(int id, String name,int idAuthor) {
		super();
		this.id = id;
		this.name = name;
		this.idAuthor = idAuthor;
	}

	
	public int getIdAuthor() {
		return idAuthor;
	}

	public JsonObject toJson() {
		return Json.createObjectBuilder().add("id", this.id).add("name", this.name).build();
	}
	
	

}
