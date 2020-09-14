package it.esedra.corso.journal;

/**
 * 
 * @author Lynda, Samuel
 *
 */
public class Author {
	private Integer id;
	private String name;
	private String email;

	public Author() {
		// TODO Auto-generated constructor stub
	}



	public Author(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public void setText(String name2) {
		// TODO Auto-generated method stub
		
	}



	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	

}