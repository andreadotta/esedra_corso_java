package it.esedra.corso.journal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import it.esedra.corso.db.DbConnect;
import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.dao.UserDao;

public class App {
	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/journal.sql";

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			// Esempio di iterazione
			// effettua la connessione al database
			Connection connection = DbConnect.connect(Journal.DBPATH);

			UserDao userdao = new UserDao(new User());
			userdao.setConnection(connection);
			List<User> users = userdao.getAll();

			for (User user : users) {
				PrintHelper.out(user.getUserName());
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
