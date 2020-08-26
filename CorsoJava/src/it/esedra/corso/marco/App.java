package it.esedra.corso.marco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.dao.UserDao;

public class App {

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/marco.sql";

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			// esempio di iterazione
			// effettua la connessione al database
			Connection connection = DbConnect.connect(DBPATH);

			UserDao userdao = new UserDao(new User());
			userdao.setConnection(connection);
			Collection<User> users = userdao.getAll();
			Iterator<User> userIterator = users.createIterator();

			while (userIterator.hasNext()) {
				User user = userIterator.next();
				PrintHelper.out(user.getName());
				PrintHelper.out(user.getSurname());
				PrintHelper.out(user.getEmail());
				PrintHelper.out(user.getPassword());
				PrintHelper.out(user.getRegistration() + "");
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
