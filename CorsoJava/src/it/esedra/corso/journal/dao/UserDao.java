package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.collections.UserCollection;

public class UserDao implements DaoInterface<User> {
	private User user;
	private Connection conn;

	public UserDao(User user) {
		super();
		this.user = user;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<User> getAll() {
		// istanzia una lista vuota di User
		Collection<User> users = new UserCollection();
		try {

			// crea lo statement
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM user");

			// ottiene il result set
			while (rs.next()) {
				// e quindi per ogni tupla crea un oggetto di tipo User
				User user = new User();
				// inserisce i dati nelle proprietà dell'oggetto
				user.setUserName(rs.getString("userName"));
				user.setUserSurname(rs.getString("userSurname"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setDataRegistration(rs.getDate("dataRegistration"));
				// aggiunge l'oggetto alla lista
				users.add(user);
			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore user dao", e.getMessage());
		}
		// restituisce la lista
		return users;

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}
