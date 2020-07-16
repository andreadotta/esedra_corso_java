package it.esedra.corso.journal.dao;


import java.util.List;

import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.Video;

public class ImageDao implements DaoInterface<Image> {

	private Image image;
	
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

}