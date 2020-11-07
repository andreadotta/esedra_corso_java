package it.esedra.corso.journal;

public class ParagraphBuilder {
	private int id;
	private String text;

	public ParagraphBuilder() {

	}

	public ParagraphBuilder(int id, String text) {
		super();
		this.id = id;
		this.text = text;

	}

	public Paragraph build() {
		return new Paragraph(id, text);

	}

	public Integer getId() {
		return id;
	}

	public ParagraphBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public String getText() {
		return text;
	}

	public ParagraphBuilder setText(String text) {
		this.text = text;
		return this;
	}

}
