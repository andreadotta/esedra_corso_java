package it.esedra.corso.journal.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.json.JsonObject;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.ParagraphBuilder;
import it.esedra.corso.journal.collections.JournalCollection;
import it.esedra.corso.journal.collections.ParagraphCollection;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class ParagraphService {

	/**
	 * Gestisce la connessione dao-db dell'oggetto Json
	 * 
	 * @param json
	 * @return Journal
	 * @throws DaoException
	 */
	
	
	public static Paragraph update(JsonObject json) throws DaoException {
		Connection connection = JournalDbConnect.connect();
		Paragraph paragraph = new ParagraphBuilder().setId(json.getInt("id", -1)).setText(json.getString("text"))
				.build();
		ParagraphDao paragraphDao = new ParagraphDao(paragraph);
		paragraphDao.setConnection(connection);

		return paragraphDao.update();
	}
	
	/**
	 * Restituisce tutti gli oggetti journal
	 * @return Collection<Journal>
	 * @throws DaoException
	 */
	public static Collection<Paragraph> getAll() throws DaoException {
		Collection<Paragraph> paragraphCollection = new ParagraphCollection();

		Connection connection = null;
		try {
			// Effettua la connessione al database
			connection = JournalDbConnect.connect();
			ParagraphDao paragraphDao = new ParagraphDao();
			paragraphDao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			paragraphCollection = paragraphDao.getAll();

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				PrintHelper.out("Errore nella chiususa della connessione");
			}
		}
		
		return paragraphCollection;
	}

}
