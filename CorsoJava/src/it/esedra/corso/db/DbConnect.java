package it.esedra.corso.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.esedra.corso.gianni.PrintHelper;

public class DbConnect {
	
    
	/**
	 * Connect to a sample database
	 * @param dbpath 
	 * @return
	 */
	public static Connection connect(String dbpath)  {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + dbpath;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            
        } catch (SQLException e) {
            //throw new Exception(e.getMessage());
        	PrintHelper.out("Errore di connessione", e.getMessage());
        } 
        
        return conn;
    }


}
