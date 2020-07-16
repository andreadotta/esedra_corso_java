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
	public List<User> getAll() {
		//istanzia una lista vuota di User
		List<User> users = new ArrayList<>();
		try {

			//crea lo statemente
			Statement stm = this.conn.createStatement();			
			//crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM user");
			
			//ottiene il result set 
			while (rs.next()) {
				// e quindi per ogni tupla crea un oggetto di tipo User
				User user = new User();
				//inserisce i dati nelle proprietà dell'oggetto
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserName(rs.getString("userName"));
				//aggiunge l'oggetto alla lista
				users.add(user);
			}
			//chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore user dao", e.getMessage());
		}
		//resituisce la lista 
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
