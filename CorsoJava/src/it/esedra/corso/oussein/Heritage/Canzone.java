package it.esedra.corso.oussein.Heritage;

public class Canzone {
	private String titoli;
	private String artist;
	private int length;

	public Canzone(String titoli, String artist, int length) {

		this.titoli = titoli;
		this.artist = artist;
		this.length = length;
	}

	public void playsong() {
		System.out.println("playing" + this.titoli + "By" + this.artist);

	}

	public String getTitoli() {
		return titoli;
	}

	public void setTitoli(String titoli) {
		this.titoli = titoli;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}