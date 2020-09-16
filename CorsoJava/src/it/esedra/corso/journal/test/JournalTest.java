package it.esedra.corso.journal.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Config;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.collections.JournalCollection;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

public class JournalTest {
	public static final int ID = 1;
	public static final String NAME = "Claudio";
    public static final String TEST_OK = "passed";
    public static final String TEST_FAIL = "failed";
	public JournalTest() {
		
	}
	
	@Test
	public void testAUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			Journal journal = new Journal();
			Journal.setId(ID);
			Journal.setName(NAME);

			JournalDao journalDao = new JournalDao(journal);
			journalDao.setConnection(connection);
			
			assertTrue(journalDao.update() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<Journal> journalCollection = new JournalCollection();

		try {
			// Effettua la connessione al database
			Connection connection = JournalDbConnect.connect();
			JournalDao journalDao = new JournalDao(new Journal());
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

				if (journal.getId() == ID && journal.getName().equals(NAME)) {
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

			Journal journalMock = new Journal();
			Journal.setId(ID);
			JournalDao journalDao = new JournalDao(journalMock);
			journalDao.setConnection(connection);

			Journal journal = journalDao.get();
			boolean found = false;

			if (journal.getId() == ID && journal.getName().equals(NAME)) {
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
			
			e.printStackTrace();
		}

	}




	
	public static void main(String[] args) {
		
		Config conf;
		try {
			
			conf = Journal.loadProperties();
			
			if (conf == null) {
				PrintHelper.out("Errore");
			} else {
				PrintHelper.out("OK");
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
}
