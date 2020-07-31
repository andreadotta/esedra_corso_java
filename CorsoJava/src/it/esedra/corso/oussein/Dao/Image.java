package it.esedra.corso.oussein.Dao;

import it.esedra.corso.journal.MultimediaResource;

/**
 * Questa classe rappresenta una immagine presente nel capitolo
 * @author bauhausk
 *
 */
public class Image  {
	private String name;
	private String luogo;
	private String color;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

	public Image() {
		// TODO Auto-generated constructor stub
	}
}
