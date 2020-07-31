package it.esedra.corso.oussein.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import it.esedra.corso.db.DbConnect;
import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.dao.UserDao;

public class App2 {

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/oussein.sql";

	public App2() {

	}

	public static void main(String[] args) {
		try {
			// Esempio di iterazione
			// effettua la connessione al database
			Connection connection = DbConnect.connect(DBPATH);

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
