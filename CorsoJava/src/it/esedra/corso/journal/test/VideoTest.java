package it.esedra.corso.journal.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.VideoBuilder;
import it.esedra.corso.journal.collections.VideoCollection;
import it.esedra.corso.journal.dao.VideoDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoTest {

	public static int ID = 1;
	public static final String SRC = "https://www.youtube.com/watch?v=1234567890";
	public static final String NAME = "VIDEO";
	public static final String TITLE = "CIAO";
	public static final String PREFIX = "$$";

	public VideoTest() {

	}

	@Test
	public void testAUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			Video video = new VideoBuilder().setSrc(SRC).setName(NAME).setTitle(TITLE).build();

			VideoDao videoDao = new VideoDao(video);
			videoDao.setConnection(connection);

			video = videoDao.update();
			assertTrue(video != null);
			
			ID = video.getId();

			video = new VideoBuilder().setId(ID).setSrc(PREFIX + SRC).setName(PREFIX + NAME)
					.setTitle(PREFIX + TITLE).build();

			videoDao = new VideoDao(video);
			videoDao.setConnection(connection);
			video = videoDao.update();
			assertTrue(video != null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<Video> videoCollection = new VideoCollection();

		try {

			Connection connection = JournalDbConnect.connect();
			VideoDao videoDao = new VideoDao();
			videoDao.setConnection(connection);

			videoCollection = videoDao.getAll();

			Iterator<Video> videoIterator = videoCollection.createIterator();

			boolean found = false;
			while (videoIterator.hasNext()) {

				Video video = videoIterator.next();

				if (video.getId() == ID && video.getSrc().equals(PREFIX + SRC) && video.getName().equals(PREFIX + NAME)
						&& video.getTitle().equals(PREFIX + TITLE)) {
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

			e.printStackTrace();
		}

	}

	@Test
	public void testGet() {

		try {

			Connection connection = JournalDbConnect.connect();
			Video videoMock = new VideoBuilder().setId(ID).build();
			
			
			VideoDao videoDao = new VideoDao(videoMock);
			videoDao.setConnection(connection);

			Video video = videoDao.get();

			
			boolean found = false;
			if (video.getId() == ID && video.getSrc().equals(PREFIX + SRC) && video.getName().equals(PREFIX + NAME)
					&& video.getTitle().equals(PREFIX + TITLE)) {
				found = true;

			}
			connection.close();
			assertTrue(found);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testZDelete() {

		try {

			Connection connection = JournalDbConnect.connect();
            Video videoMock = new VideoBuilder().setId(ID).build();;
			
			VideoDao videoDao = new VideoDao(videoMock);
			videoDao.setConnection(connection);

			boolean deleted = videoDao.delete();
			assertTrue(deleted);

			Video video = videoDao.get();

			assertNull(video);

			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
