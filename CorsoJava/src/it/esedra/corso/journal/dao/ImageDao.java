package it.esedra.corso.journal.dao;


import java.sql.Connection;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.collections.ImageCollection;

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
	public Collection<Image> getAll() {
		Collection<Image> images = new ImageCollection();
		
		return null;
		
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}