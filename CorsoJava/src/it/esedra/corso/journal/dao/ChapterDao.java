package it.esedra.corso.journal.dao;

import java.util.List;

import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.Video;

public class ChapterDao implements DaoInterface<Chapter> {

	private Chapter chapter;
	
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
}