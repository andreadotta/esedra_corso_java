package it.esedra.corso.journal.test;

import java.sql.Connection;
import java.sql.SQLException;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.collections.UserCollection;
import it.esedra.corso.journal.dao.UserDao;

public class UserTest {

	public UserTest() {
		// TODO Auto-generated constructor stub
	}

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/marco.db";

	public static void main(String[] args) {

		Collection<User> userCollection = new UserCollection();

		try {
			// effettua la connessione al database
			Connection connection = DbConnect.connect(DBPATH);

			UserDao userdao = new UserDao(new User());
			userdao.setConnection(connection);
			userCollection = userdao.getAll();
			Iterator<User> userIterator = userCollection.createIterator();

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
