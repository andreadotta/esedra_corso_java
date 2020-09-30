 package it.esedra.corso.journal;


public class JournalBuilder {

	public class setId {

		public setId(int int1) {
		
		}

		public AuthorBuilder setName(String name) {
			
			return null;
		}

	}


	private Integer id;
	private String name;
	

	public JournalBuilder(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		

	}
	
	public Journal build() {
		return new Journal(id, name);
	}
	
	public Integer getId() {
		return id;
	}


	public JournalBuilder setId(Integer id) {
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

