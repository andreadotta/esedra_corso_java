package it.esedra.corso.journal;


public class ChapterBuilder {

	private Integer id;
	private String title;
	private String date;

	
	public ChapterBuilder(Integer id, String title, String date ) {
		super();
		this.id = id;
		this.title = title;
        this.date = date ;
	}

		public ChapterBuilder() {
		
	}

		public Chapter build() {
			return new Chapter(id, title, date);
		}


	public Integer getId() {
		return id;
	}

	public ChapterBuilder setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	
	public ChapterBuilder setTitle( String title) {
		this.title =  title;
		return this;
	}
	public ChapterBuilder setDate(  String date) {
		this.date =  date;
		return this;
	}	
	public String getDate() {
		return date;
	}

	}


