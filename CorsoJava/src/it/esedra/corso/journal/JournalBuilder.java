package it.esedra.corso.journal;

public class JournalBuilder {
	
	private int id;
	private String name;
	
	public JournalBuilder() {
		
	}
	
	public JournalBuilder(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Journal build() {
		return new Journal(id, name);
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


