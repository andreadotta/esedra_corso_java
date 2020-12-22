package it.esedra.journal.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import it.esedra.journal.Config;

public class JournalDbConnect {
	
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
	
	/**
	 * Connect to a sample database
	 */
	public static Connection connect() {
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:" + System.getProperty("user.dir") + JournalDbConnect.loadProperties().getDbpath();
			// create a connection to the database
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
			// throw new Exception(e.getMessage());
			System.out.println(e.getMessage());
		}

		return conn;
	}

}
