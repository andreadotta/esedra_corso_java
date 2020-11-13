package it.esedra.corso.journal.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.json.JsonObject;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.AuthorBuilder;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.collections.AuthorCollection;
import it.esedra.corso.journal.collections.JournalCollection;
import it.esedra.corso.journal.dao.AuthorDao;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class AuthorService {
	/**
	 * Gestisce la connessione dao-db dell'oggetto Json
	 * 
	 * @param json
	 * @return Journal
	 * @throws DaoException
	 */
	

	public static Author update(JsonObject json) throws DaoException {
		Connection connection = JournalDbConnect.connect();
		Author author = new AuthorBuilder().setId(json.getInt("id", -1)).setName(json.getString("name")).setEmail(json.getString("email")).build();
		AuthorDao authorDao = new AuthorDao(author);
		authorDao.setConnection(connection);

		return authorDao.update();
	}
	/**
	 * Restituisce tutti gli oggetti journal
	 * @return Collection<Journal>
	 * @throws DaoException
	 */
	public static Collection<Author> getAll() throws DaoException {
		Collection<Author> authorCollection = new AuthorCollection();

		Connection connection = null;
		try {
			// Effettua la connessione al database
			connection = JournalDbConnect.connect();
			AuthorDao authorDao = new AuthorDao();
			authorDao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			authorCollection = authorDao.getAll();

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				PrintHelper.out("Errore nella chiususa della connessione");
			}
		}
		
		return authorCollection;
	}

}
