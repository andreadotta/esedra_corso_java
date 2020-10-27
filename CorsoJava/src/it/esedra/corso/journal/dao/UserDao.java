package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.UserBuilder;
import it.esedra.corso.journal.collections.UserCollection;
import it.esedra.corso.journal.execeptions.DaoException;

public class UserDao implements DaoInterface<User> {

	private User user;
	private Connection conn;

	public UserDao() {

	}

	public UserDao(User user) {
		super();
		this.user = user;
	}

	@Override
	public boolean delete() throws DaoException {

		boolean success = true;

		try {

			// Crea lo statement
			Statement stm = this.conn.createStatement();
			// Crea il result set al quale passa la query
			int rs = stm.executeUpdate("DELETE FROM user WHERE id =" + this.user.getId());

			if (rs > 0) {
				success = true;
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		}
		// Restituisce l'oggetto
		return success;
	}

	@Override
	public Collection<User> getAll() throws DaoException {
		// Istanzia una lista vuota di User
		Collection<User> users = new UserCollection();
		try {

			// Crea lo statement
			Statement stm = this.conn.createStatement();
			// Crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM user");

			// Ottiene il result set. . .
			while (rs.next()) {
				// . . .e quindi per ogni tupla crea un oggetto di tipo User
				User user = new UserBuilder().setId(rs.getInt("id")).setName(rs.getString("name"))
						.setSurname(rs.getString("surname")).setEmail(rs.getString("email"))
						.setPassword(rs.getString("password")).setRegistration(rs.getString("registration")).build();

				// Aggiunge l'oggetto alla lista
				users.add(user);
			}
			// Chiude le connessioni e il result set
			rs.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		// Restituisce la lista
		return users;

	}

	@Override
	public User update() throws DaoException {

		if (user == null) {
			PrintHelper.out("user non può essere null.");
			return null;
		}

		User userCheck = this.get();
		User copy = null;

		try {

			if (userCheck != null) {
				String sql = "UPDATE user SET name = ?, surname = ?, email = ?, password = ?, registration = ? WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, user.getName());
				stm.setString(2, user.getSurname());
				stm.setString(3, user.getEmail());
				stm.setString(4, user.getPassword());
				stm.setString(5, user.getRegistration());

				stm.setInt(6, user.getId());

				if (stm.executeUpdate() > 0) {

					copy = new UserBuilder().setId(user.getId()).setName(user.getName()).setSurname(user.getSurname())
							.setEmail(user.getEmail()).setPassword(user.getPassword())
							.setRegistration(user.getRegistration()).build();
				}

				stm.close();

			} else {
				String sql = "INSERT INTO user (name, surname, email, password, registration) VALUES (?, ?, ?, ?, ?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, user.getName());
				stm.setString(2, user.getSurname());
				stm.setString(3, user.getEmail());
				stm.setString(4, user.getPassword());
				stm.setString(5, user.getRegistration());

				if (stm.executeUpdate() > 0) {

					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {

						copy = new UserBuilder().setId(genKeys.getInt(1)).setName(user.getName())
								.setSurname(user.getSurname()).setEmail(user.getEmail()).setPassword(user.getPassword())
								.setRegistration(user.getRegistration()).build();
					}
				}

				stm.close();
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return copy;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override 
	public User get() throws DaoException {
		// Inizializza un nuovo oggetto User
		User user = null;

		try {

			// Crea lo statement
			Statement stm = this.conn.createStatement();
			// Crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE id =" + this.user.getId());

			while (rs.next()) {
				// Istanzia l'elemento User
				user = new UserBuilder().setId(rs.getInt("id")).setName(rs.getString("name"))
						.setSurname(rs.getString("surname")).setEmail(rs.getString("email"))
						.setPassword(rs.getString("password")).setRegistration(rs.getString("registration")).build();

			}
			// Chiude le connessioni e il result set
			rs.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		// Restituisce l'oggetto
		return user;
	}
}
