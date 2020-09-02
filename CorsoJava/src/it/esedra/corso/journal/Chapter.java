package it.esedra.corso.journal;

import java.util.Date;

/**
 * Questa classe è un capitolo del diario
 * 

 * 
 */
public class Chapter {

	private int id;
	
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	private Date date;



	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public Chapter() {
		// TODO Auto-generated constructor stub
	}

}
