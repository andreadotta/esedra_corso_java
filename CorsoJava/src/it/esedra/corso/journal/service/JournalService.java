package it.esedra.corso.journal.service;

import java.sql.Connection;

import javax.json.JsonObject;

import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class JournalService {
	/**
	 * Gestisce la connessione dao-db dell'oggetto Json
	 * 
	 * @param json
	 * @return Journal
	 * @throws DaoException
	 */
	
	public static Journal update(JsonObject json) throws DaoException {
		Connection connection = JournalDbConnect.connect();
		Journal journal = new JournalBuilder().setId(json.getInt("id", -1)).setName(json.getString("name")).build();
		JournalDao journalDao = new JournalDao(journal);
		journalDao.setConnection(connection);

		return journalDao.update();
	}

}
