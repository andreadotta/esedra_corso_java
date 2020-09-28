package it.esedra.corso.journal.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.AuthorBuilder;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.ChapterBuilder;
import it.esedra.corso.journal.collections.ChapterCollection;
import it.esedra.corso.journal.dao.AuthorDao;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChapterTest {

	private static int ID = 1;
	private static final String TITLE = "TITLE";
	private static final Date DATE = null;
	public static final String PREFIX = "$$";

	@Test
	public void testAUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			Chapter chapter = new ChapterBuilder().setTitle(TITLE).setDate(DATE).build();

			ChapterDao chapterDao = new ChapterDao(chapter);
			chapterDao.setConnection(connection);
			chapter = chapterDao.update();
			assertTrue(chapter != null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testGetAll() {

		Collection<Chapter> chapterCollection = new ChapterCollection();

		try {
			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			ChapterDao chapterdao = new ChapterDao(null);
			chapterdao.setConnection(connection);

			chapterCollection = chapterdao.getAll();

			Iterator<Chapter> chapterIterator = chapterCollection.createIterator();

			boolean found = false;
			while (chapterIterator.hasNext()) {

				Chapter chapter1 = chapterIterator.next();

				if (chapter1.getId() == ID && chapter1.getTitle().equals(TITLE)) {
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

	@Test
	public void testGet() {

		try {
			// Effettua la connessione al database
			Connection connection = JournalDbConnect.connect();
			Chapter chapterMock = new ChapterBuilder().setId(ID).build();

			ChapterDao chapterDao = new ChapterDao(chapterMock);
			chapterDao.setConnection(connection);

			Chapter chapter = chapterDao.get();
			boolean found = false;

			if (chapter.getId() == ID && chapter.getTitle().equals(PREFIX + TITLE)
					&& chapter.getDate().equals(PREFIX + DATE)) {
				{
					found = true;
				}

				connection.close();

				assertTrue(found);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testZDelete() {

		try {

			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			Chapter chapterMock = new ChapterBuilder().setId(ID).build();

			ChapterDao chapterDao = new ChapterDao(chapterMock);
			chapterDao.setConnection(connection);
			boolean deleted = chapterDao.delete();
			assertTrue(deleted);

			Chapter chapter = chapterDao.get();
			assertNull(chapter);

			connection.close();

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
}
