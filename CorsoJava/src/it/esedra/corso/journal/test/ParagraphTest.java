package it.esedra.corso.journal.test;

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
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.collections.ParagraphCollection;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParagraphTest {
	public static final int ID = 1;
	public static final String TEXT = "il primo paragraph del diario";

	@Test
	public void testAUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Paragraph paragraph = new Paragraph();
			paragraph.setId(ID);
			paragraph.setText(TEXT);

			ParagraphDao paragraphDao = new ParagraphDao(paragraph);
			paragraphDao.setConnection(connection);

			assertTrue(paragraphDao.update() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<Paragraph> paragraphs = new ParagraphCollection();

		try {
			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			ParagraphDao paragraphdao = new ParagraphDao(new Paragraph());
			paragraphdao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			Collection<Paragraph> paragraphsCollection = paragraphdao.getAll();

			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<Paragraph> paragraphIterator = paragraphsCollection.createIterator();

			// cicla sugli elementi Paragraph della paragraphCollection e restituisce per
			// ogni
			// elemento i valori delle colonne della tabella text
			boolean found = false;
			while (paragraphIterator.hasNext()) {

				Paragraph paragraph = paragraphIterator.next();

				if (paragraph.getId() == ID && paragraph.getText().equals(TEXT)) {
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

			Paragraph paragraphMock = new Paragraph();
			paragraphMock.setId(ID);
			ParagraphDao paragraphDao = new ParagraphDao(paragraphMock);
			paragraphDao.setConnection(connection);

			Paragraph paragraph = paragraphDao.get();
			boolean found = false;

			if (paragraph.getId() == ID && paragraph.getText().equals(TEXT)) {
				found = true;
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

}
