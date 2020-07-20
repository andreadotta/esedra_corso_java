package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.util.List;

import it.esedra.corso.journal.Video;

public class VideoDao implements DaoInterface<Video> { 

	private Video video;
	private Connection conn;
	
	public VideoDao(Video video) {
		super();
		this.video = video;
	}

    @Override
	public void update() {
		
	}

	@Override
	public void delete() {
		

	}

	@Override
	public List<Video> getAll() {
		
		return null;
		
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}