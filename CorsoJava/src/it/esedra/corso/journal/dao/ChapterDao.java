package it.esedra.corso.journal.dao;

import java.sql.Connection;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.Chapter;

public class ChapterDao implements DaoInterface<Chapter> {

	private Chapter chapter;
	private Connection conn;
	
	public ChapterDao(Chapter chapter) {
		super();
		this.chapter = chapter;
	}
    
    @Override
	public void update() {
		
	}

	@Override
	public void delete() {
		

	}

	@Override
	public Collection<Chapter> getAll() {
		
		return null;
		
	}
	
	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}