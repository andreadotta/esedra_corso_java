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
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.collections.AuthorCollection;
import it.esedra.corso.journal.dao.AuthorDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorTest {
	public static int ID = 1;
	public static final String NAME = " Mbrain Linda";
	public static final String EMAIL = "info@mcbrain.com";
	public static final String PREFIX = "$$";

	@BeforeClass
	public static void setup() {

		try {
			DbUtil.rebuildDb();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {

		Collection<Author> authorCollection = new AuthorCollection();

		try {
			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			AuthorDao authordao = new AuthorDao(new Author());
			authordao.setConnection(connection);

			//
			authorCollection = authordao.getAll();

			//
			Iterator<Author> authorIterator = authorCollection.createIterator();

			boolean found = false;
			while (authorIterator.hasNext()) {

				Author author = authorIterator.next();

				if (author.getId() == ID && author.getName().equals(PREFIX + NAME)
						&& author.getEmail().equals(PREFIX + EMAIL)) {
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
	public void testAUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Author author = new Author();

			author.setName(NAME);
			author.setEmail(EMAIL);

			AuthorDao authorDao = new AuthorDao(author);
			authorDao.setConnection(connection);

			assertTrue(authorDao.update() > 0);
			// setto l'ID con il valore della chiave generata dal database
			ID = author.getId();

			author.setName(PREFIX + NAME);
			author.setEmail(PREFIX + EMAIL);

			authorDao = new AuthorDao(author);
			authorDao.setConnection(connection);
			assertTrue(authorDao.update() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGet() {

		try {

			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			Author authorMock = new Author();
			authorMock.setId(ID);
			AuthorDao authorDao = new AuthorDao(authorMock);
			authorDao.setConnection(connection);

			Author author = authorDao.get();

			boolean found = false;

			if (author.getId() == ID && author.getName().equals(PREFIX + NAME)
					&& author.getEmail().equals(PREFIX + EMAIL)) {

				found = true;

			}

			connection.close();

			assertTrue(found);

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}