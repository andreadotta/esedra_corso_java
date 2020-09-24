package it.esedra.corso.journal;

public class ParagraphBuilder {
	private Integer id;
	private String text;

	public ParagraphBuilder() {

	}

	public ParagraphBuilder(Integer id, String text) {
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

	public ParagraphBuilder setId(Integer id) {
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
