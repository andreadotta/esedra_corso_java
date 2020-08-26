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

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/marco.sql";

	public static void main(String[] args) {

		Collection<User> userCollection = new UserCollection();

		User username1 = new User();
		User username2 = new User();

		username1.setUserName("Andrea");
		username1.setUserSurname("Dotta");
		username2.setUserName("Roberto");
		username2.setUserSurname("Baldi");

		userCollection.add(username1);
		userCollection.add(username2);

		try {
			// effettua la connessione al database
			Connection connection = DbConnect.connect(DBPATH);

			UserDao userdao = new UserDao(new User());
			userdao.setConnection(connection);
			userCollection = userdao.getAll();
			Iterator<User> userIterator = userCollection.createIterator();

			while (userIterator.hasNext()) {
				User user = userIterator.next();
				PrintHelper.out(user.getUserName());
				PrintHelper.out(user.getUserSurname());
				PrintHelper.out(user.getUserEmail());
				PrintHelper.out(user.getUserPassword());
				PrintHelper.out(user.getDataRegistration() + "");
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
