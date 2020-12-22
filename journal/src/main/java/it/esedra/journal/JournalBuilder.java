package it.esedra.journal;

public class JournalBuilder {
	
	private int id;
	private String name;
	private int idAuthor;
	
	public JournalBuilder() {
		
	}
	
	public JournalBuilder(int id, String name, int idAuthor ) {
		super();
		this.id = id;
		this.name = name;
		this.idAuthor = idAuthor;
	}
	
	public Journal build() {
		return new Journal(id, name, idAuthor);
	}
	
	

	public int getAuthor() {
		return idAuthor;
	}
	
	public JournalBuilder setidAuthor( int idAuthor) {
		this.idAuthor = idAuthor;
		return this;
	}

	public int getId() {
		return id;
	}

	public JournalBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public JournalBuilder setName(String name) {
		this.name = name;
		return this;
	}

}


