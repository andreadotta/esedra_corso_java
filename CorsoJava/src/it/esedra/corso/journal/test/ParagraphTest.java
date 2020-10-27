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

import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.ParagraphBuilder;
import it.esedra.corso.journal.collections.ParagraphCollection;

import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParagraphTest {
	public static int ID = 1;
	public static final String TEXT = "il primo paragraph del diario";
	public static final String PREFIX = "$$";

	@Test
	public void testAUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Paragraph paragraph = new ParagraphBuilder().setText(TEXT).build();

			ParagraphDao paragraphDao = new ParagraphDao(paragraph);
			paragraphDao.setConnection(connection);
			paragraph = paragraphDao.update();
			assertTrue(paragraph != null);

			ID = paragraph.getId();

			paragraph = new ParagraphBuilder().setId(ID).setText(PREFIX + TEXT).build();

			paragraphDao = new ParagraphDao(paragraph);
			paragraphDao.setConnection(connection);
			paragraph = paragraphDao.update();
			assertTrue(paragraph != null);

			connection.close();

		} catch (DaoException | SQLException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetAll() {

		Collection<Paragraph> paragraphCollection = new ParagraphCollection();

		Connection connection = null;
		try {
			// Effettua la connessione al database

			connection = JournalDbConnect.connect();
			ParagraphDao paragraphdao = new ParagraphDao();
			paragraphdao.setConnection(connection);
			
			paragraphCollection = paragraphdao.getAll();

			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<Paragraph> paragraphIterator = paragraphCollection.createIterator();

			// cicla sugli elementi Paragraph della paragraphCollection e restituisce per
			// ogni
			// elemento i valori delle colonne della tabella text
			boolean found = false;
			while (paragraphIterator.hasNext()) {

				Paragraph paragraph1 = paragraphIterator.next();

				if (paragraph1.getId() == ID && paragraph1.getText().equals(PREFIX + TEXT)) {
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

	@Test
	public void testGet() {

		try {
			// Effettua la connessione al database
			Connection connection = JournalDbConnect.connect();

			Paragraph paragraphMock = new ParagraphBuilder().setId(ID).build();

			ParagraphDao paragraphDao = new ParagraphDao(paragraphMock);
			paragraphDao.setConnection(connection);

			Paragraph paragraph = paragraphDao.get();
			boolean found = false;

			if (paragraph.getId() == ID && paragraph.getText().equals(PREFIX + TEXT)) {
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

			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			Paragraph paragraphMock = new ParagraphBuilder().setId(ID).build();

			ParagraphDao paragraphDao = new ParagraphDao(paragraphMock);
			paragraphDao.setConnection(connection);
			boolean deleted = paragraphDao.delete();
			assertTrue(deleted);

			Paragraph paragraph = paragraphDao.get();
			assertNull(paragraph);

			connection.close();

		} catch (DaoException | SQLException e) {

			fail(e.getMessage());

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

}
