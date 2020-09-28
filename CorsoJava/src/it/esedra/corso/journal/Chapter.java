package it.esedra.corso.journal;

import java.util.Date;

/**
 * Questa classe è un capitol del diario
 * 

 * 
 */
public class Chapter {
	private final int id;
	private final String title;
	private final Date date;
	
	public Chapter(Integer id, String title, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;

	}
	
	public int getId() {
		return id;
	}

	
	public String getTitle() {
		return title;
	}

	
	public Date getDate() {
		return date;
	}


}

	



	


