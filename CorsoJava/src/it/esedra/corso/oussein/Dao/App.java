package it.esedra.corso.oussein.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import it.esedra.corso.db.DbConnect;
import it.esedra.corso.gianni.PrintHelper;

import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.User;

import it.esedra.corso.journal.dao.UserDao;

public class App {

	public static final String DBPATH = System.getProperty("chapter.dir") + "/sqlite/db/oussein.sql";

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			// Esempio di iterazione
			// effettua la connessione al database
			Connection connection = DbConnect.connect(DBPATH);

			ChapterDao chapterdao = new ChapterDao(new Chapter());
			chapterdao.setConnection(connection);
			List<Chapter> chapters = chapterdao.getAll();

			for (Chapter chapter : chapters) {
				PrintHelper.out(chapter.getNome());
				PrintHelper.out(chapter.getCongnome());
				PrintHelper.out(chapter.getCitta());
				PrintHelper.out(chapter.getProfessione());
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
