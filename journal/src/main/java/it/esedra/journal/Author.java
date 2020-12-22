package it.esedra.journal;

import it.esedra.corso.collections.interfaces.DataObjectInterface;

/**
 * 
 * @author Lynda, Samuel API http://localhost/journal/author/11
 */
public class Author implements DataObjectInterface {
	private final Integer id;
	private final String name;
	private final String email;

	public Author(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;

	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}