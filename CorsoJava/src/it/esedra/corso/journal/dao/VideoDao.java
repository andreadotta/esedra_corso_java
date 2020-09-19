package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public int update() {
		int affectedRows = 0;
		if (video == null) {
			PrintHelper.out("author non può essere null.");
			return affectedRows;
		}
		Video videoCheck = this.get();

		try {

			if (videoCheck != null) {
				String sql = "UPDATE video SET src= ?, name= ?, title= ?  WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, video.getSrc());
				stm.setString(2, video.getName());
				stm.setString(3, video.getTitle());

				stm.setInt(4, video.getId());

				affectedRows = stm.executeUpdate();

				stm.close();

			} else {
				String sql = "INSERT INTO image ( src,name,title) VALUES (?,?,?) ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				
				stm.setString(1, video.getSrc());
				stm.setString(2, video.getName());
				stm.setString(3, video.getTitle());

				affectedRows = stm.executeUpdate();
				ResultSet genKeys = stm.getGeneratedKeys();
				if (genKeys.next()) {
					video.setId(genKeys.getInt(1));
				}

				stm.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore video dao", e.getMessage());
		}

		return affectedRows;

	}

	@Override
	public boolean delete() {

		boolean success = true;

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM video WHERE id = " + this.video.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}

		return success;

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

	@Override
	public Video get() {
		Video video = null;

		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM video WHERE id = " + this.video.getId());

			while (rs.next()) {

				video = new Video();
				video.setId(rs.getInt("id"));
				video.setSrc(rs.getString("src"));
				video.setName(rs.getString("name"));
				video.setTitle(rs.getString("title"));

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}
		return video;
	}
}