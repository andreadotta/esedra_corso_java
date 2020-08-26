package it.esedra.corso.journal;

/**
 * Questa classe è un paragrafo del diario
 * 
 * @author Oussein
 * 
 */
public class Paragraph<T> {

	private int id;
	private T text;
	
	public Paragraph(int id, T text) {
		this.id=id;
		this.text= text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public T getText() {
		return text;
	}
	public void setText(T text) {
		this.text = text;
	}
	public Paragraph() {
		

}
}
