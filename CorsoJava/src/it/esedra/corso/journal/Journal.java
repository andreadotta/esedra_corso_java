package it.esedra.corso.journal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import it.esedra.corso.helpers.PrintHelper;

/**
 * Classe base dell'applicazione
 * 
 * @author bauhausk
 *
 */
public class Journal {

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
