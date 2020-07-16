package it.esedra.corso.samuel;

import java.sql.Connection;

import it.esedra.corso.db.DbConnect;
import it.esedra.corso.journal.Journal;

public class App {

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/samuel.sql";
	
	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = DbConnect.connect(DBPATH);	
		
	}

}
