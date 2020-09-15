package it.esedra.corso.journal.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Journal;

public class JournalDbConnect {
	/**
     * Connect to a sample database
     */
    public static Connection connect()  {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" +  System.getProperty("user.dir") + Journal.loadProperties().getDbpath();
            // create a connection to the database
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
            //throw new Exception(e.getMessage());
        	PrintHelper.out("Errore", e.getMessage());
        } 
        
        return conn;
    }


}
