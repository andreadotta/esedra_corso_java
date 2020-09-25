package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.ImageBuilder;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.VideoBuilder;
import it.esedra.corso.journal.collections.ImageCollection;
import it.esedra.corso.journal.collections.VideoCollection;

public class ImageDao implements DaoInterface<Image> {

	private Image image;
	private Connection conn;

	public ImageDao(Image image) {
		super();
		this.image = image;
	}

	@Override
	public boolean delete() {

		boolean success = true;

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM image WHERE id = " + this.image.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (Exception e) {
			PrintHelper.out("Errore image dao", e.getMessage());
		}

		return success;

	}
	
	@Override
	public Collection<Image> getAll() {
		Collection<Image> images = new ImageCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM image");

			while (rs.next()) {
				
				Image image = new ImageBuilder().setId(rs.getInt("id")).setSrc(rs.getString("src"))
						.setName(rs.getString("name")).build();

				
				images.add(image);
			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore image dao", e.getMessage());
		}

		return images;

	}

	@Override
	public Image update() {

		if (image == null) {
			PrintHelper.out("image non può essere null.");
			return null;
		}
		Image imageCheck = this.get();
		Image copy = null;

		try {

			if (imageCheck != null) {
				String sql = "UPDATE image SET src= ?, name= ?   WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, image.getSrc());
				stm.setString(2, image.getName());
				stm.setInt(3, image.getId());

				

                if (stm.executeUpdate() > 0) {
					
					copy = new ImageBuilder().setId(image.getId()).setSrc(image.getSrc()).setName(image.getName())
							.build();
				}

				stm.close();

			} else {
				String sql = "INSERT INTO image (src, name) VALUES (?,?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, image.getSrc());
				stm.setString(2, image.getName());
				

				if (stm.executeUpdate() > 0) {

					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {

						copy = new ImageBuilder().setId(genKeys.getInt(1)).setSrc(image.getSrc())
								.setName(image.getName()).build();
					}
				}

				stm.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore image dao", e.getMessage());
		}

		return copy;

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
				
				image = new ImageBuilder().setId(rs.getInt("id")).setSrc(rs.getString("src"))
						.setName(rs.getString("name")).build();

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore image dao", e.getMessage());
		}
		return image;
	}
}