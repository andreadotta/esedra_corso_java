package it.esedra.corso.journal.test;

import java.sql.Connection;
import java.sql.SQLException;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.collections.VideoCollection;
import it.esedra.corso.journal.dao.VideoDao;
import it.esedra.corso.journal.db.JournalDbConnect;

public class VideoTest {

	public VideoTest() {

	}

	public void testUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			Video video = new Video();
			video.setId(1);
			video.setSrc("a");
			video.setName("b");
			video.setTitle("c");

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

			
			while (videoIterator.hasNext()) {
				Video video = videoIterator.next();
				PrintHelper.out("Video ID: " + video.getId());
				PrintHelper.out("Src: " + video.getSrc());
				PrintHelper.out("Name: " + video.getName());
				PrintHelper.out("Title: " + video.getTitle());

				if (video.getSrc() == "a" && video.getName() == "b" && 
						video.getTitle() == "c") {
					PrintHelper.out("I dati coincidono.");
				} else {
					PrintHelper.out("Errore. I dati non coincidono.");
				}

			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		VideoTest videoTest = new VideoTest();
		videoTest.testUpdate();
		videoTest.testGetAll();

	}

}
