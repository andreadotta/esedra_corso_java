package it.esedra.corso.journal.service;

import java.sql.Connection;

import javax.json.JsonObject;

import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.ParagraphBuilder;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class ParagraphService {

	public static Paragraph update(JsonObject json) throws DaoException {
		Connection connection = JournalDbConnect.connect();
		Paragraph paragraph = new ParagraphBuilder().setId(json.getInt("id", -1)).setText(json.getString("text"))
				.build();
		ParagraphDao paragraphDao = new ParagraphDao(paragraph);
		paragraphDao.setConnection(connection);

		return paragraphDao.update();
	}

}
