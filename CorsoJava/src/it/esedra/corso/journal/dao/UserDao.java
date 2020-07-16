package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.db.DbConnect;
import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.User;

public class UserDao implements DaoInterface<User> {
	private User user;

	public UserDao(User user) {
		super();
		this.user = user;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		try {

			
			Connection connection = DbConnect.connect(Journal.DBPATH);	
			
			Statement stm = connection.createStatement();			

			ResultSet rs = stm.executeQuery("SELECT * FROM user");
			
			while (rs.next()) {
				User user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserName(rs.getString("userName"));
				users.add(user);
			}
			rs.close();
			connection.close();
		} catch (Exception e) {

			PrintHelper.out("Errore user dao", e.getMessage());
		}

		return users;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
