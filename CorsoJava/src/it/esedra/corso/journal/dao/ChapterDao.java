package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.util.List;

import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.Video;

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
	public List<Chapter> getAll() {
		
		return null;
		
	}
	
	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}