package it.esedra.corso.journal.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.collections.AuthorCollection;
import it.esedra.corso.journal.dao.AuthorDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

public class AuthorTest {
	public static final int ID = 1;
	public static final String NAME = " Mbrain Linda";
	public static final String EMAIL = "info@mcbrain.com";

	@BeforeAll
	public void setup() {

		try {
			DbUtil.rebuildDb();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Author author = new Author();
			author.setId(ID);
			author.setText(NAME);
			author.setText(EMAIL);

			AuthorDao authorDao = new AuthorDao(author);
			authorDao.setConnection(connection);

			assertTrue(authorDao.update() > 0);

		} catch (Exception e) {
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

				Author author1 = authorIterator.next();

				if (author1.getId() == ID && author1.getName().equals(NAME)) {
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

}
