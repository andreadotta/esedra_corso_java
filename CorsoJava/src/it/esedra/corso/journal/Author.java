package it.esedra.corso.journal;
/**
 * 
 * @author Lynda, Samuel
 *
 */
public class Author {

	private String name;
	private String email;

	public Author() {
		// TODO Auto-generated constructor stub
	}
	private String src;

	public Author(String name, String email, String src) {
		super();
		this.name = name;
		this.email = email;
		this.src = src;
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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}