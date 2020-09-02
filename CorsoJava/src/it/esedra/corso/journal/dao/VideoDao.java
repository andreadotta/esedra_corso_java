package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.collections.interfaces.Collection;
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
				video.setVideoTitle(rs.getString("title"));
				video.setVideoId(rs.getString("id"));
				video.setVideoUrl(rs.getString("url"));
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