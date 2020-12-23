package it.esedra.journal;

import it.esedra.journal.collections.interfaces.DataObjectInterface;

/**
 * Classe base dell'applicazione
 * 
 * @author bauhausk
 *
 */
public class Journal implements DataObjectInterface, Cloneable {

	private int id;
	private String name;
	private int idAuthor;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Journal(int id, String name, int idAuthor ) {
		super();
		this.id = id;
		this.name = name;
		this.idAuthor = idAuthor;
	}

	public int getIdAuthor() {
		return idAuthor;
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
