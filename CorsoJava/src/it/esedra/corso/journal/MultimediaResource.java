package it.esedra.corso.journal;

/**
 * Questa classe rappresenta una immagine presente nel capitolo
 * @author bauhausk
 *
 */
public class MultimediaResource {
	private String name; //noma dell'immagine
	private String src; //source path assoluto
	public MultimediaResource(String name,String src) {
		this.name=name;
		this.src=src;
		
		
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
