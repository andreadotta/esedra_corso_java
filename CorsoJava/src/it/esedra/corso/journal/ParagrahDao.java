package it.esedra.corso.journal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.dao.DaoInterface;
import it.esedra.corso.oussein.Dao.Chapter;

public class ParagrahDao<T> implements DaoInterface<T> {

	private T paragraph;

	public ParagrahDao(T  paragraph) {
		super();
		this.paragraph = paragraph;
	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

	}

	@Override
	public Collection<T> getAll() {
		List<T> paragraphs = new ArrayList<>();

		return (Collection<T>) paragraphs;

	}

	@Override
	public void setConnection(Connection con) {

	}

}
