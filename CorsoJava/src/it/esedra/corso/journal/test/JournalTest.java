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
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.collections.JournalCollection;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JournalTest {
	public static int ID = 1;
	public static final String NAME = "Claudio";
	public static final String TEST_OK = "passed";
	public static final String TEST_FAIL = "failed";
	public static final String PREFIX = "$$";

	@Test
	public void testAUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Journal journal = new JournalBuilder().setName(NAME).build();

			JournalDao journalDao = new JournalDao(journal);
			journalDao.setConnection(connection);

			journal = journalDao.update();
			assertTrue(journal != null);
			ID = journal.getId();

			journal = new JournalBuilder().setId(ID).setName(PREFIX + NAME).build();
			journalDao = new JournalDao(journal);
			journalDao.setConnection(connection);
			journalDao.update();
			assertTrue(journal != null);
			
			connection.close();

		} catch (SQLException | DaoException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetAll() {

		Collection<Journal> journalCollection = new JournalCollection();
		
		Connection connection = null;
		try {
			// Effettua la connessione al database
			connection = JournalDbConnect.connect();
			JournalDao journalDao = new JournalDao();
			journalDao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			journalCollection = journalDao.getAll();

			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<Journal> journalIterator = journalCollection.createIterator();

			/**
			 * Cicla sugli elementi Journal della journalCollection e restituisce per ogni
			 * elemento i valori delle colonne della tabella journal.
			 * 
			 * L'if controlla l'effettiva esistenza dei dati del test case nelle colonne
			 * della tabella journal.
			 * 
			 */

			boolean found = false;
			while (journalIterator.hasNext()) {

				Journal journal = journalIterator.next();

				if (journal.getId() == ID && journal.getName().equals(PREFIX + NAME)) {
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

			Journal journalMock = new JournalBuilder().setId(ID).build();
			JournalDao journalDao = new JournalDao(journalMock);
			journalDao.setConnection(connection);

			Journal journal = journalDao.get();
			boolean found = false;

			if (journal.getId() == ID && journal.getName().equals(PREFIX + NAME)) {
				found = true;
			}

			connection.close();

			assertTrue(found);

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

	@Test
	public void testZDelete() {

		try {

			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			Journal journalMock = new JournalBuilder().setId(ID).build();
			JournalDao journalDao = new JournalDao(journalMock);
			journalDao.setConnection(connection);
			boolean deleted = journalDao.delete();
			assertTrue(deleted);

			Journal journal = journalDao.get();
			assertNull(journal);

			connection.close();

		} catch (DaoException | SQLException e) {

			fail(e.getMessage());

		}

	}

}
