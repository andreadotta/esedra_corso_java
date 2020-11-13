package it.esedra.corso.journal.service;

import java.sql.Connection;

import javax.json.JsonObject;

import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.AuthorBuilder;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.dao.AuthorDao;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class AuthorService {
	

	public static Author update(JsonObject json) throws DaoException {
		Connection connection = JournalDbConnect.connect();
		Author author = new AuthorBuilder().setId(json.getInt("id", -1)).setName(json.getString("name")).setEmail(json.getString("email")).build();
		AuthorDao authorDao = new AuthorDao(author);
		authorDao.setConnection(connection);

		return authorDao.update();
	}

}
