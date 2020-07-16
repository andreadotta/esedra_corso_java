package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.util.List;

import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.Video;

public class JournalDao implements DaoInterface<Journal> {

	private Journal journal; 
	private Connection conn;
	
	public JournalDao(Journal journal) {
		super();
		this.journal = journal;
	}
    @Override
	public void update() {
		
	}

	@Override
	public void delete() {
		

	}

	@Override
	public List<Journal> getAll() {
		
		return null;
		
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}