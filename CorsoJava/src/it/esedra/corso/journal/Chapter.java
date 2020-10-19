package it.esedra.corso.journal;

import java.util.Date;

/**
 * Questa classe è un capitol del diario
 * 
 * 
 * 
 */
public class Chapter {
	private final Integer id;
	private final String title;
	private final String date;

	public Chapter(Integer id, String title, String date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;

	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

}
