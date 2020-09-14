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
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.collections.VideoCollection;
import it.esedra.corso.journal.dao.VideoDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

public class VideoTest {

	public static final int ID = 1;
	public static final String SRC = "https://www.youtube.com/watch?v=1234567890";
	public static final String NAME = "VIDEO";
	public static final String TITLE = "CIAO";

	public VideoTest() {

	}

	@Test
	public void testUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			Video video = new Video();
			video.setId(ID);
			video.setSrc(SRC);
			video.setName(NAME);
			video.setTitle(TITLE);

			VideoDao videoDao = new VideoDao(video);
			videoDao.setConnection(connection);
			
			assertTrue(videoDao.update() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<Video> videoCollection = new VideoCollection();

		try {

			Connection connection = JournalDbConnect.connect();
			VideoDao videoDao = new VideoDao(new Video());
			videoDao.setConnection(connection);

			videoCollection = videoDao.getAll();

			Iterator<Video> videoIterator = videoCollection.createIterator();

			boolean found = false;
			while (videoIterator.hasNext()) {

				Video video = videoIterator.next();
				
				if (video.getId() == ID && video.getSrc().equals(SRC) && video.getName().equals(NAME)
						&& video.getTitle().equals(TITLE)) {
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
			Video videoMock = new Video();
			videoMock.setId(ID);
			VideoDao videoDao = new VideoDao(videoMock);
			videoDao.setConnection(connection);

			Video video = videoDao.get();

			connection.close();
			boolean found = false;
			if (video.getId() == ID && video.getSrc().equals(SRC) && video.getName().equals(NAME)
					&& video.getTitle().equals(TITLE)) {
				found = true;

			}
			assertTrue(found);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
