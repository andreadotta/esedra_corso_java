package it.esedra.corso.journal;

public class ParagraphBuilder {
	private int id;
	private String text;
	private int idJournal;

	public ParagraphBuilder() {

	}

	public ParagraphBuilder(int id, String text,int idJournal) {
		super();
		this.id = id;
		this.text = text;
		this.idJournal= idJournal;

	}

	public Paragraph build() {
		return new Paragraph(id, text, idJournal);

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
	
	public int getIdJournal() {
		return idJournal;
	}
	
	public ParagraphBuilder setIdJournal(int idJournal) {
		this.idJournal = idJournal;
		return this;
	}

}
