package it.esedra.corso.journal.dao;

import java.sql.Connection;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.Journal;

public class JournalDao implements DaoInterface<Journal> {

	private Journal journal; 
	private Connection conn;
	 
	public JournalDao(Journal journal) {
		super();
		this.journal = journal;
	}
    @Override
	public int update() {
    	
    	return 0;
		
	}

	@Override
	public boolean delete() {
		
		return false;

	}

	@Override
	public Collection<Journal> getAll() {
		
		return null;
		
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
	@Override
	public Journal get() {
		// TODO Auto-generated method stub
		return null;
	}
}