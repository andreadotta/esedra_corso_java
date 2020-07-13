package it.esedra.corso;

import it.esedra.corso.lynda.JournalData;

public abstract class Journal {

	private JournalData data = new JournalData();
	/**
	 * @param genre
	 * @param tittle
	 * @param author
	 * @param page
	 */
	public Journal(String genre, String tittle, String author, int page) {
		super();
		this.data.setGenre(genre);
		this.data.setTittle(tittle);
		this.data.setAuthor(author);
		this.data.setPage(page);
	}
	 
	public Journal() {
		super();
		
	}
	public String getGenre() {
		return data.getGenre();
	}
	public void setGenre(String genre) {
		this.data.setGenre(genre);
	}
	public String getTittle() {
		return data.getTittle();
	}
	public void setTittle(String tittle) {
		this.data.setTittle(tittle);
	}
	public String getAuthor() {
		return data.getAuthor();
	}
	public void setAuthor(String author) {
		this.data.setAuthor(author);
	}
	public int getPage() {
		return data.getPage();
	}
	public void setPage(int page) {
		this.data.setPage(page);
	}
}
