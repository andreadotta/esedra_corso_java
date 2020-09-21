package it.esedra.corso.journal;

/**
 * Questa classe è un video presente nel capitolo
 * @author bauhausk
 *
 */
public class Video extends MultimediaResource {
private int id;
private String title;
private String name;
private String src;

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



	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}


public Video() {


}
}
