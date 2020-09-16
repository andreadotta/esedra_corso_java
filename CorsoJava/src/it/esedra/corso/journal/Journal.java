package it.esedra.corso.journal;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;



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

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Journal() {

	}
	/**
	 * Carico le configurazioni dell'app presenti sul file di properties
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
	
	

}
