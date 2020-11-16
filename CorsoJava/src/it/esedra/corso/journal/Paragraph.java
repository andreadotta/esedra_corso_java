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

	public Paragraph(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public   int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	
	public static Config loadProperties() throws IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));

		Config config = new Config();
		config.setDbpath(prop.getProperty("dbpath"));

		return config;

	}
	
	public JsonObject toJson() {
		return Json.createObjectBuilder().add("id", this.id).add("text", this.text).build();
	}
	

}
