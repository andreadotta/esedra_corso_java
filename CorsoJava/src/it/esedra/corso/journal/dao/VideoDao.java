package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.VideoBuilder;
import it.esedra.corso.journal.collections.VideoCollection;
import it.esedra.corso.journal.execeptions.DaoException;

public class VideoDao implements DaoInterface<Video> {

	private Video video;
	private Connection conn;

	public VideoDao() {

	}

	public VideoDao(Video video) {
		super();
		this.video = video;
	}

	@Override
	public boolean delete() throws DaoException {

		boolean success = true;
		

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM video WHERE id = " + this.video.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (Exception e) {
			throw new DaoException("Errore durante update Video ",e);
		}

		return success;

	}

	@Override
	public Collection<Video> getAll() throws DaoException {
		Collection<Video> videos = new VideoCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM video");

			while (rs.next()) {

				Video video = new VideoBuilder().setId(rs.getInt("id")).setSrc(rs.getString("src"))
						.setName(rs.getString("name")).setTitle(rs.getString("title")).build();

				videos.add(video);
			}
			rs.close();
		} catch (Exception e) {
			throw new DaoException("Errore durante update Video ",e);
		}

		return videos;

	}

	@Override
	public Video update() throws DaoException {

		if (video == null) {
			PrintHelper.out("video non può essere null.");
			return null;
		}
		Video videoCheck = this.get();
		Video copy = null;

		try {

			if (videoCheck != null) {
				String sql = "UPDATE video SET src= ?, name= ?, title= ?  WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, video.getSrc());
				stm.setString(2, video.getName());
				stm.setString(3, video.getTitle());

				stm.setInt(4, video.getId());

				if (stm.executeUpdate() > 0) {

					copy = new VideoBuilder().setId(video.getId()).setSrc(video.getSrc()).setName(video.getName())
							.setTitle(video.getTitle()).build();
				}

				stm.close();

			} else {
				String sql = "INSERT INTO video (src, name, title) VALUES (?,?,?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, video.getSrc());
				stm.setString(2, video.getName());
				stm.setString(3, video.getTitle());

				if (stm.executeUpdate() > 0) {

					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {

						copy = new VideoBuilder().setId(genKeys.getInt(1)).setSrc(video.getSrc())
								.setName(video.getName()).setTitle(video.getTitle()).build();
					}
				}

				stm.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Errore durante update Video ",e);
		}

		return copy;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public Video get() throws DaoException  {
		Video video = null;

		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM video WHERE id = " + this.video.getId());

			while (rs.next()) {

				video = new VideoBuilder().setId(rs.getInt("id")).setSrc(rs.getString("src"))
						.setName(rs.getString("name")).setTitle(rs.getString("title")).build();

			}
			rs.close();
		} catch (Exception e) {
			throw new DaoException("Errore durante update Video ",e);
		}
		return video;
	}
}