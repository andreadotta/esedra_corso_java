package it.esedra.corso.journal;

/**
 * Questa classe è un video presente nel capitolo
 * @author bauhausk
 *
 */
public class Video extends MultimediaResource {

	private String title;
	private Integer id;
	private String url;
	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Video() {
		
	}


}
