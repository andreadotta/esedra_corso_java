package it.esedra.corso.journal;

/**
 * Questa classe è un paragrafo del diario
 * 
 * @author Oussein
 * 
 */
public class Paragraph {

	private final String text;
	private final Integer id;

	public Paragraph(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

}
