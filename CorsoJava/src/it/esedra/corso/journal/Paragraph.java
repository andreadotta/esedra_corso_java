package it.esedra.corso.journal;

/**
 * Questa classe è un paragrafo del diario
 * 
 * @author Oussein
 * 
 */
public class Paragraph {

	private int id;
	private String text;
	
	public Paragraph(int id, String text) {
		this.id=id;
		this.text= text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Paragraph() {
		

}
}
