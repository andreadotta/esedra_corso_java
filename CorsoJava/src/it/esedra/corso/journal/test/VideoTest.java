package it.esedra.corso.journal.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
			videoDao.update();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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

				PrintHelper.out("id: " + video.getId());
				PrintHelper.out("Src: " + video.getSrc());
				PrintHelper.out("Name: " + video.getName());
				PrintHelper.out("Title: " + video.getTitle());
				if (video.getId() == ID && video.getSrc().equals(SRC) && video.getName().equals(NAME)
						&& video.getTitle().equals(TITLE)) {
					found = true;
					break;

				}

			}
			connection.close();
			if (found == true) {
				PrintHelper.out(JournalTest.TEST_OK);

			} else {
				PrintHelper.out(JournalTest.TEST_FAIL);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			DbUtil.rebuildDb();
		    VideoTest videoTest = new VideoTest();
		    videoTest.testUpdate();
		    videoTest.testGetAll();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
