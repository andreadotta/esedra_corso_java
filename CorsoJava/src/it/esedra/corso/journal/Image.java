package it.esedra.corso.journal;

/**
 * Questa classe rappresenta una immagine presente nel capitolo
 * 
 * @author Nayem
 *
 */
public class Image extends MultimediaResource  {


private final String title;
	
	public Image(int id, String src, String name, String title) {
		super(id, src, name);
		this.title = title;


	}

	public String getTitle() {
		return title;
	}

}
