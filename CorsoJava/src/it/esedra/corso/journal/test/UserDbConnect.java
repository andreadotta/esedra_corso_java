package it.esedra.corso.journal.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;

public class UserDbConnect {

	public static Connection connect() {
		Connection conn = null;
		try {
			// parametri database marco.db (in cui troviamo la tabella user)
			String url = "jdbc:sqlite:/home/jesoobamboo/git/esedra_corso_java/CorsoJava/sqlite/db/marco.db";
			// crea la connessione col database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			// throw new Exception(e.getMessage());
			PrintHelper.out("Errore di connessione", e.getMessage());
		}

		return conn;
	}

}
