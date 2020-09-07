package it.esedra.corso.journal.test;

import java.sql.Connection;
import java.sql.SQLException;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.collections.ImageCollection;
import it.esedra.corso.journal.dao.ImageDao;

public class ImagedaoTest {

	public static final String DBPATH = System.getProperty("image.dir") + "/sqlite/db/nayem.db";

	public static void main(String[] args) {

		Collection<Image> images = new ImageCollection();

		try {

			Connection connection = DbConnect.connect(DBPATH);
			ImageDao imagedao = new ImageDao(new Image());
			imagedao.setConnection(connection);

			Collection<Image> imagesCollection = imagedao.getAll();

			Iterator<Image> imageIterator = imagesCollection.createIterator();

			while (imageIterator.hasNext()) {

				Image image = imageIterator.next();
				PrintHelper.out("id :" + " " + image.getId());
				PrintHelper.out("src :" + " " + image.getSrc());

				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String getDbpath() {
		return DBPATH;
	}

}
