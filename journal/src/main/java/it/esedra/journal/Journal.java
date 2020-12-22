package it.esedra.journal;

import it.esedra.corso.collections.interfaces.DataObjectInterface;

/**
 * Classe base dell'applicazione
 * 
 * @author bauhausk
 *
 */
public class Journal implements DataObjectInterface, Cloneable {

	private int id;
	private String name;
	private Author author;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Journal(int id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

	@Override
	public Journal clone() {
		try {
			@SuppressWarnings("unused")
			Journal j = (Journal) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
