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
import it.esedra.corso.journal.db.JournalDbConnect;

public class UserTest {

	// Parametri database
	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/marco.db";

	public UserTest() {

	}

	public void testUpdate() {

		try {
			Connection connection = JournalDbConnect.connect();

			User user = new User();
			user.setId(1);
			user.setName("Claudio");
			user.setSurname("Cini");
			user.setEmail("ccini@foo.com");
			user.setPassword("bge");
			user.setRegistration("01/06/2018");

			UserDao userDao = new UserDao(user);
			userDao.setConnection(connection);
			userDao.update();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testGetAll() {

		Collection<User> userCollection = new UserCollection();

		try {
			// Effettua la connessione al database
			Connection connection = DbConnect.connect(DBPATH);
			UserDao userdao = new UserDao(new User());
			userdao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			userCollection = userdao.getAll();

			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<User> userIterator = userCollection.createIterator();

			// cicla sugli elementi User della userCollection e restituisce per ogni
			// elemento i valori delle colonne della tabella user
			while (userIterator.hasNext()) {
				User user = userIterator.next();
				PrintHelper.out("User ID: " + user.getId());
				PrintHelper.out("Nome e cognome: " + user.getName() + " " + user.getSurname());
				PrintHelper.out("Email: " + user.getEmail());
				PrintHelper.out("Password: " + user.getPassword());
				PrintHelper.out("Registration Date: " + user.getRegistration());
				PrintHelper.out("*****************************");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		UserTest ut = new UserTest();
		ut.testUpdate();
		ut.testGetAll();

	}

}
