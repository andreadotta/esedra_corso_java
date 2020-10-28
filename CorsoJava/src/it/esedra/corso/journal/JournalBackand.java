package it.esedra.corso.journal;


public class JournalBackand {

		private Integer id;
		private String name;
	

		public JournalBackand() {
		
		}
		
		public JournalBackand(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		

		}


		public Integer getId() {
			return id;
		}

		public JournalBackand setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getName() {
			return name;
		}

		public JournalBackand setName(String name) {
			this.name = name;
			return this;
		
	
			
		}

	}

	
		
	

