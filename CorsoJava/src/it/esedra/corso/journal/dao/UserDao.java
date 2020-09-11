package it.esedra.corso.journal.dao;

import java.sql.Connection;
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
	public void delete() {

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
	public void update() {
		
		user = this.get();

		try {
			Statement stm = this.conn.createStatement();
			
			if (user != null) {
				
				
				
			} else {
				stm.executeUpdate("INSERT INTO user (id, name, surname, email, password, registration) VALUES ( "
						+ user.getId() + ", '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getEmail()
						+ "', '" + user.getPassword() + "', '" + user.getRegistration() + "' )");
			}
			
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore user dao", e.getMessage());
		}

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
