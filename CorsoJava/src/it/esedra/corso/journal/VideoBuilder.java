package it.esedra.corso.journal;

public class VideoBuilder {

	private int id;
	private String src;
	private String name;
	private String title;
	
	

	public VideoBuilder() {

	}

	public VideoBuilder(int id, String src, String name, String title) {
		super();
		this.id = id;
		this.src = src;
		this.name = name;
		this.title = title;

	}

	public Video build() {
		return new Video(id, src, name, title);
	}

	public int getId() {
		return id;
	}

	public VideoBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public String getSrc() {
		return src;
	}

	public VideoBuilder setSrc(String src) {
		this.src = src;
		return this;
	}

	public String getName() {
		return name;
	}

	public VideoBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public VideoBuilder setTitle(String title) {
		this.title = title;
		return this;
	}


}
