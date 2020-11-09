package it.esedra.corso.journal.service;

import java.sql.Connection;

import javax.json.JsonObject;

import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.UserBuilder;
import it.esedra.corso.journal.dao.UserDao;
import it.esedra.corso.journal.db.JournalDbConnect;
import it.esedra.corso.journal.execeptions.DaoException;

public class UserService {
	
	public static User update(JsonObject json) throws DaoException {
		
		Connection connection = JournalDbConnect.connect();
		User user = new UserBuilder().setId(json.getInt("id", -1)).setName(json.getString("name"))
				.setSurname(json.getString("surname")).setEmail(json.getString("email"))
				.setPassword(json.getString("password")).setRegistration(json.getString("registration"))
				.build();
		
		UserDao userDao = new UserDao(user);
		userDao.setConnection(connection);
		
		return userDao.update();
		
	}

}
