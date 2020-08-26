package it.esedra.corso.journal.dao;

import java.sql.Connection;

import it.esedra.corso.collections.interfaces.Collection;
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
	public Collection<Video> getAll() {
		Collection<Video> videos = new VideoCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM video");

			while (rs.next()) {

				Video video = new Video();
				video.setVideoTitle(rs.getString("Title"));
				video.setVideoID(rs.getString("ID"));
				video.setVideoURL(rs.getString("URL"));
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