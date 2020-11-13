package it.esedra.corso.journal.service;

import java.sql.Connection;

import javax.json.JsonObject;

import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.ChapterBuilder;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.dao.JournalDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class ChapterService {
	public static Chapter update(JsonObject json) throws DaoException {
		Connection connection = JournalDbConnect.connect();
		Chapter chapter = new ChapterBuilder()
				.setId(json.getInt("id", -1))
				.setTitle(json.getString("title"))
				.setDate(json.getString("date"))
				.build();
		
		ChapterDao chapterDao = new ChapterDao(chapter);
		chapterDao.setConnection(connection);
		
		return chapterDao.update();
	}

}


