package it.esedra.corso.journal.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import it.esedra.corso.journal.execeptions.DaoException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoTest {

	public static int ID = 1;
	public static final String SRC = "https://www.youtube.com/watch?v=1234567890";
	public static final String NAME = "VIDEO";
	public static final String TITLE = "CIAO";
	public static final String PREFIX = "$$";
	public static final int IDIMAGE = 1;
	public static final int IDPARAGRAPH = 1;

	public VideoTest() {

	}

	@Test
	public void testAUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			Video video = new VideoBuilder()
					.setSrc(SRC)
					.setName(NAME)
					.setTitle(TITLE)
					.setIdImage(IDIMAGE)
					.setIdParagraph(IDPARAGRAPH)
					.build();

			VideoDao videoDao = new VideoDao(video);
			videoDao.setConnection(connection);

			video = videoDao.update();
			assertTrue(video != null);

			ID = video.getId();

			video = new VideoBuilder()
					.setId(ID)
					.setSrc(PREFIX + SRC)
					.setName(PREFIX + NAME)
					.setTitle(PREFIX + TITLE)
					.setIdImage(IDIMAGE)
					.setIdParagraph(IDPARAGRAPH)
					.build();

			videoDao = new VideoDao(video);
			videoDao.setConnection(connection);
			video = videoDao.update();
			assertTrue(video != null);

			connection.close();

		} catch (DaoException | SQLException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetAll() {

		Collection<Video> videoCollection = new VideoCollection();

		Connection connection = null;
		try {

			connection = JournalDbConnect.connect();
			VideoDao videoDao = new VideoDao();
			videoDao.setConnection(connection);

			videoCollection = videoDao.getAll();

			Iterator<Video> videoIterator = videoCollection.createIterator();

			boolean found = false;
			while (videoIterator.hasNext()) {

				Video video = videoIterator.next();

				if (video.getId() == ID
						&& video.getSrc()
						.equals(PREFIX + SRC)
						&& video.getName()
						.equals(PREFIX + NAME)
						&& video.getTitle()
						.equals(PREFIX + TITLE)
						&& video
						.getIdImage()
						== IDIMAGE
						&& video
						.getIdParagraph() 
						== IDPARAGRAPH) {
					found = true;
					break;

				}

			}

			assertTrue(found);

		} catch (DaoException e) {
			fail(e.getMessage());

		} finally {
			try {

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				fail(e.getMessage());
			}
		}

	}

	@BeforeClass
	public static void setup() {

		try {
			DbUtil.rebuildDb();

		} catch (IOException e) {

			fail(e.getMessage());
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
			if (video.getId() == ID
					&& video.getSrc()
					.equals(PREFIX + SRC)
					&& video.getName()
					.equals(PREFIX + NAME)
					&& video.getTitle()
					.equals(PREFIX + TITLE)
					&& video
					.getIdImage() 
					== IDIMAGE
					&& video
					.getIdParagraph() 
					== IDPARAGRAPH) {
				found = true;

			}
			connection.close();
			assertTrue(found);
		} catch (DaoException | SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testZDelete() {

		try {

			Connection connection = JournalDbConnect.connect();
			Video videoMock = new VideoBuilder().setId(ID).build();

			VideoDao videoDao = new VideoDao(videoMock);
			videoDao.setConnection(connection);

			boolean deleted = videoDao.delete();
			assertTrue(deleted);

			Video video = videoDao.get();

			assertNull(video);

			connection.close();
		} catch (DaoException | SQLException e) {

			fail(e.getMessage());

		}

	}
}
