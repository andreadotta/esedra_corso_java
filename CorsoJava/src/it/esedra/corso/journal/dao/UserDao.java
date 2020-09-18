package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	public boolean delete() {

		return false;

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
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRegistration(rs.getString("registration"));
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
	public int update() {
		int affectedRows = 0;

		if (user == null) {
			PrintHelper.out("user non può essere null.");
			return affectedRows;
		}

		User userCheck = this.get();

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

				affectedRows = stm.executeUpdate();
				stm.close();

			} else {
				String sql = "INSERT INTO user ( name, surname, email, password, registration) VALUES ( ?, ?, ?, ?, ?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);
				
				stm.setString(1, user.getName());
				stm.setString(2, user.getSurname());
				stm.setString(3, user.getEmail());
				stm.setString(4, user.getPassword());
				stm.setString(5, user.getRegistration());

				affectedRows = stm.executeUpdate();
				ResultSet genKeys = stm.getGeneratedKeys();
				if (genKeys.next()) {
					user.setId(genKeys.getInt(1));
				}
				
				stm.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore user dao", e.getMessage());
		}

		return affectedRows;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public User get() {
		// inizializza un nuovo oggetto User
		User user = null;

		try {

			// crea lo statement
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE id =" + this.user.getId());

			while (rs.next()) {
				// istanzia l'elemento User
				user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRegistration(rs.getString("registration"));

			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore user dao", e.getMessage());
		}
		// restituisce l'oggetto
		return user;
	}
}
