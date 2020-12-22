package it.esedra.journal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import it.esedra.corso.collections.interfaces.DataObjectInterface;

/**
 * Questa classe è un capitolo del journal
 * 
 * 
 * 
 */
public class Chapter implements DataObjectInterface {
	private int id;
	private String title;
	private String date;
	private int idJournal;

	public Chapter(int id, String title, String date, int idJournal) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.idJournal = idJournal;

	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public int getIdJournal() {
		return idJournal;
	}

	public static Config loadProperties() throws IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));

		Config config = new Config();
		config.setDbpath(prop.getProperty("dbpath"));

		return config;

	}

}
