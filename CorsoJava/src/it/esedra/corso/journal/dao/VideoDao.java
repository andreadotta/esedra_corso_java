package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.collections.VideoCollection;

public class VideoDao implements DaoInterface<Video> {
    
	private Video video;  
	private Connection conn;

	public VideoDao(Video video) {
		super();
		this.video = video;
	}

	@Override
	public void update() {
		
		if (video == null) {
			PrintHelper.out("video non può essere null");
			return;
		}
		try {
			Statement stm = this.conn.createStatement();
			stm.executeUpdate("INSERT INTO video (id, src, name, title) VALUES ( "
					+ video.getId() + ", '" + video.getSrc() + "', '" + video.getName() + "', '" + video.getTitle() + "' )");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore video dao", e.getMessage());
		}


	}

	@Override
	public void delete() {

	}

	@Override
	public Collection<Video> getAll() {
		Collection<Video> videos = new VideoCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM video");

			while (rs.next()) {

				Video video = new Video();
				video.setId(rs.getInt("id"));
				video.setSrc(rs.getString("src"));
				video.setName(rs.getString("name"));
				video.setTitle(rs.getString("title"));
				videos.add(video);

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}

		return videos;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}