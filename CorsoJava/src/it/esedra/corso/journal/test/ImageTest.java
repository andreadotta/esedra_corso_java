package it.esedra.corso.journal.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.Image;
import it.esedra.corso.journal.collections.ImageCollection;
import it.esedra.corso.journal.collections.ImageCollection;
import it.esedra.corso.journal.dao.ImageDao;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.dao.VideoDao;
import it.esedra.corso.journal.dao.ImageDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

public class ImageTest {

	public static final int ID = 1;
	public static final String SRC = "https:www.youtube.com";

	@Test
	public void testUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Image image = new Image();
			image.setId(ID);
			image.setSrc(SRC);

			ImageDao imageDao = new ImageDao(image);
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

				

				if (image.getId() == ID && image.getSrc().equals(SRC)) {
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

	@BeforeAll
	public void setup() {

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
			if (image.getId() == ID && image.getSrc().equals(SRC)) {
				found = true;

			}
			assertTrue(found);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
