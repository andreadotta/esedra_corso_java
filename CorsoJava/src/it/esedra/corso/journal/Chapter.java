package it.esedra.corso.journal;

import java.util.Date;

/**
 * Questa classe è un capitolo del diario
 * 
 * @author Oussein
 * 
 */
public class Chapter {

	private String title;

	private Date date;

	private String[] paragraph;

	
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

	public String[] getParagraph() {
		return paragraph;
	}

	public void setParagraph(String[] paragraph) {
		this.paragraph = paragraph;
	}

	public Chapter() {
		// TODO Auto-generated constructor stub
	}

}
