package it.esedra.corso.oussein.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.dao.DaoInterface;

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
	public List<Image> getAll() {

		List<Image> images = new ArrayList<>();
		try {

			// crea lo statemente
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM image");

			// ottiene il result set
			while (rs.next()) {
				// e quindi per ogni tupla crea un oggetto di tipo User
				Image image = new Image();
				// inserisce i dati nelle proprietà dell'oggetto
				image.setName(rs.getString("name"));
				image.setLuogo(rs.getString("luogo"));
				image.setColor(rs.getString("color"));

				// aggiunge l'oggetto alla lista
				images.add(image);
			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore image dao", e.getMessage());
		}
		// resituisce la lista

		return images;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}