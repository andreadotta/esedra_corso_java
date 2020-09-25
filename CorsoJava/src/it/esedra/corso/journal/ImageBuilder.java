package it.esedra.corso.journal;

public class ImageBuilder {
	
	private int id;
	private String src;
	private String name;
	private String title;
	
	

	public ImageBuilder() {

	}

	public ImageBuilder(int id, String src, String name, String title) {
		super();
		this.id = id;
		this.src = src;
		this.name = name;
		this.title = title;

	}

	public Image build() {
		return new Image(id, src, name, title);
	}

	public int getId() {
		return id;
	}

	public ImageBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public String getSrc() {
		return src;
	}

	public ImageBuilder setSrc(String src) {
		this.src = src;
		return this;
	}

	public String getName() {
		return name;
	}

	public ImageBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public ImageBuilder setTitle(String title) {
		this.title = title;
		return this;
	}


}


