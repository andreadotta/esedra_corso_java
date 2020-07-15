package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.User;
import it.esedra.corso.journal.db.JournalDbConnect;

public class UserDao implements DaoInterface {
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
	public void get() {

		try {
			Connection connection = JournalDbConnect.connect();	
			
			Statement stm = connection.createStatement();			

			ResultSet rs = stm.executeQuery("SELECT * FROM user");
			
			while (rs.next()) {
				PrintHelper.out("Dato utente", rs.getString("userEmail") + " " + rs.getString("userName"));
			}
			rs.close();
			connection.close();
		} catch (Exception e) {

			PrintHelper.out("Errore user dao", e.getMessage());
		}

		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
