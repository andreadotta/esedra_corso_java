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

	}

	// Parametri database 
	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/marco.db";

	public static void main(String[] args) {

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

}
