package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.Video;
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

		 if (image == null) {
			PrintHelper.out("image non può essere null.");
			return;
		}
		try {
			Statement stm = this.conn.createStatement();
			stm.executeUpdate("INSERT INTO image (id, src) VALUES ( " + image.getId() + ", '" + image.getSrc() + "')");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore image dao", e.getMessage());
		}

	}

	@Override
	public void delete() {

	}

	@Override
	public Collection<Image> getAll() {
		Collection<Image> images = new ImageCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM image");

			while (rs.next()) {

				Image image = new Image();
				image.setId(rs.getInt("id"));
				image.setSrc(rs.getString("src"));
				images.add(image);
			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}

		return images;

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public Image get() {

		Image image = null;

		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM image WHERE id = " + this.image.getId());

			while (rs.next()) {

				image = new Image();
				image.setId(rs.getInt("id"));
				image.setSrc(rs.getString("src"));

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Error image dao", e.getMessage());
		}
		return image;
	}
}