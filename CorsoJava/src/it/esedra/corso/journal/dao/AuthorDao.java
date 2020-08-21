package it.esedra.corso.journal.dao;

import java.sql.Connection;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.Author;

public class AuthorDao implements DaoInterface<Author> {

	private Author author;
	private Connection conn;
	
	public AuthorDao(Author author) {
		super();
		this.author = author;
	}
	@Override
	public void update() {
		
	}

	@Override
	public void delete() {
		

	}

	@Override
	public Collection<Author> getAll() {
		
		return null;
		
	}
	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		
	}

}
