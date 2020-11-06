package it.esedra.corso.journal;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Classe base dell'applicazione
 * 
 * @author bauhausk
 *
 */
public class Journal {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Journal(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Carico le configurazioni dell'app presenti sul file di properties
	 * 
	 * @return Config
	 * @throws IOException
	 */
	public static Config loadProperties() throws IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));

		Config config = new Config();
		config.setDbpath(prop.getProperty("dbpath"));

		return config;

	}
	
	public JsonObject toJson() {
		return Json.createObjectBuilder().add("id", this.id).add("name", this.name).build();
	}
	
	

}
