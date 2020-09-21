package it.esedra.corso.journal.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.collections.ImageCollection;
import it.esedra.corso.journal.dao.ImageDao;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageTest {

	public static int ID = 1;
	public static final String SRC = "https:www.youtube.com";
	public static final String NAME= "Gulia" ;
	public static final String PREFIX = "$$";

	@Test
	public void testAUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Image image = new Image();
			image.setId(ID);
			image.setSrc(SRC);
			image.setSrc(NAME);

			ImageDao imageDao = new ImageDao(image);
			imageDao.setConnection(connection);

			assertTrue(imageDao.update() > 0);
			ID = image.getId();

			image.setSrc(PREFIX + SRC);
			image.setSrc(PREFIX + NAME);
			imageDao = new ImageDao(image);
			imageDao.setConnection(connection);
			assertTrue(imageDao.update() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<Image> images = new ImageCollection();

		try {

			Connection connection = JournalDbConnect.connect();
			ImageDao imagedao = new ImageDao(new Image());
			imagedao.setConnection(connection);

			Collection<Image> imagesCollection = imagedao.getAll();

			Iterator<Image> imageIterator = imagesCollection.createIterator();

			boolean found = false;
			while (imageIterator.hasNext()) {

				Image image = imageIterator.next();

				if (image.getId() == ID && image.getSrc().equals(PREFIX + SRC) && image.getName().equals(PREFIX + NAME)) {
					found = true;
					break;

				}

			}

			connection.close();
			assertTrue(found);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public static void setup() {

		try {
			DbUtil.rebuildDb();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGet() {

		try {

			Connection connection = JournalDbConnect.connect();
			Image imageMock = new Image();
			imageMock.setId(ID);
			ImageDao imageDao = new ImageDao(imageMock);
			imageDao.setConnection(connection);

			Image image = imageDao.get();

			connection.close();
			boolean found = false;
			if (image.getId() == ID && image.getSrc().equals(PREFIX + SRC) && image.getName().equals(PREFIX + NAME)) {
				found = true;

			}
			assertTrue(found);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testZDelete() {

		try {

			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			Image imageMock = new Image();
			imageMock.setId(ID);
			ImageDao imageDao = new ImageDao(imageMock);
			imageDao.setConnection(connection);
			boolean deleted = imageDao.delete();
			assertTrue(deleted);

			Image image = imageDao.get();
			assertNull(image);

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
