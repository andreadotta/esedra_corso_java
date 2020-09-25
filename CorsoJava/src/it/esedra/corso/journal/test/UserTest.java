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
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.UserBuilder;
import it.esedra.corso.journal.collections.UserCollection;
import it.esedra.corso.journal.dao.UserDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {

	// Parametri database
	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/journal.db";
	// Dichiarazione delle costanti di classe per il test case
	public static int ID = 1;
	public static final String NAME = "Claudio";
	public static final String SURNAME = "Cini";
	public static final String EMAIL = "ccini@foo.com";
	public static final String PASSWORD = "bge";
	public static final String REGISTRATION = "01/06/2018";

	public static final String PREFIX = "$$";

	public UserTest() {

	}

	@Test
	public void testAUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			User user = new UserBuilder().setName(NAME).setSurname(SURNAME).setEmail(EMAIL).setPassword(PASSWORD)
					.setRegistration(REGISTRATION).build();

			UserDao userDao = new UserDao(user);
			userDao.setConnection(connection);

			user = userDao.update();
			assertTrue(user != null);
			// setto l'ID con il valore della chiave generata dal database
			ID = user.getId();

			user = new UserBuilder().setId(ID).setName(PREFIX + NAME).setSurname(PREFIX + SURNAME)
					.setEmail(PREFIX + EMAIL).setPassword(PREFIX + PASSWORD).setRegistration(PREFIX + REGISTRATION)
					.build();

			userDao = new UserDao(user);
			userDao.setConnection(connection);
			user = userDao.update();
			assertTrue(user != null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<User> userCollection = new UserCollection();

		try {
			// Effettua la connessione al database
			Connection connection = JournalDbConnect.connect();
			UserDao userDao = new UserDao();
			userDao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			userCollection = userDao.getAll();

			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<User> userIterator = userCollection.createIterator();

			/**
			 * Cicla sugli elementi User della userCollection e restituisce per ogni
			 * elemento i valori delle colonne della tabella user.
			 * 
			 * L'if controlla l'effettiva esistenza dei dati del test case nelle colonne
			 * della tabella user.
			 * 
			 */

			boolean found = false;
			while (userIterator.hasNext()) {

				User user = userIterator.next();

				if (user.getId() == ID && user.getName().equals(PREFIX + NAME)
						&& user.getSurname().equals(PREFIX + SURNAME) && user.getEmail().equals(PREFIX + EMAIL)
						&& user.getPassword().equals(PREFIX + PASSWORD)
						&& user.getRegistration().equals(PREFIX + REGISTRATION)) {
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

			User userMock = new UserBuilder().setId(ID).build();

			UserDao userDao = new UserDao(userMock);
			userDao.setConnection(connection);

			User user = userDao.get();

			boolean found = false;

			if (user.getId() == ID && user.getName().equals(PREFIX + NAME) && user.getSurname().equals(PREFIX + SURNAME)
					&& user.getEmail().equals(PREFIX + EMAIL) && user.getPassword().equals(PREFIX + PASSWORD)
					&& user.getRegistration().equals(PREFIX + REGISTRATION)) {
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
			// Effettua la connessione al database
			Connection connection = JournalDbConnect.connect();
			User userMock = new UserBuilder().setId(ID).build();

			UserDao userDao = new UserDao(userMock);
			userDao.setConnection(connection);

			boolean deleted = userDao.delete();
			assertTrue(deleted);

			User user = userDao.get();

			assertNull(user);

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

			e.printStackTrace();
		}

	}

}
