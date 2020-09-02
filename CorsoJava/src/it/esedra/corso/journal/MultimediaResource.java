package it.esedra.corso.journal;

/**
 * Questa classe rappresenta una immagine presente nel capitolo
 * 
 * @author bauhausk
 *
 */
public class MultimediaResource {
	private String name; // noma dell'immagine
	private String src; // source path assoluto
	private int id; // source path assoluto

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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
