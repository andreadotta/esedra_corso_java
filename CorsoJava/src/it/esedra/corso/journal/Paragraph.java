package it.esedra.corso.journal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;

import it.esedra.corso.collections.interfaces.DataObjectInterface;

/**
 * Questa classe è un paragrafo del diario
 * 
 * @author Oussein
 * 
 */
public class Paragraph implements DataObjectInterface  {

	private  String text;
	private  int id;
	private int idJournal;

	public Paragraph(int id, String text) {
		super();
		this.id = id;
		this.text = text;
		this.idJournal=idJournal;
	}

	public   int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	public int getIdJournal() {
		return idJournal;
	}
	
	

	
	
	public JsonObject toJson() {
		return Json.createObjectBuilder().add("id", this.id).add("text", this.text).build();
	}
	

}
