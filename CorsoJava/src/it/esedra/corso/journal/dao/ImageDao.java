package it.esedra.corso.journal.dao;


import java.sql.Connection;
import java.util.List;

import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.Video;

public class ImageDao implements DaoInterface<Image> {

	private Image image;
	private Connection conn;
	
	public ImageDao(Image image) {
		super();
		this.image = image;
	}
    
    @Override
	public void update() {
		
	}

	@Override
	public void delete() {
		

	}

	@Override
	public List<Image> getAll() {
		
		return null;
		
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}