package it.esedra.corso.journal;

/**
 * Questa classe è un video presente nel capitolo
 * 
 *
 */
public class Video extends MultimediaResource {
	
	
	private final String title;
	
	public Video(int id, String src, String name, String title) {
		super();
		this.title = title;

	}

	public String getTitle() {
		return title;
	}
	
	





}
