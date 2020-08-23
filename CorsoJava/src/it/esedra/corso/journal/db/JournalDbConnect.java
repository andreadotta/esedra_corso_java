package it.esedra.corso.journal.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.esedra.corso.helpers.PrintHelper;

public class JournalDbConnect {
	/**
     * Connect to a sample database
     */
    public static Connection connect()  {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/JesooBamboo/git/esedra_corso_java/CorsoJava/sqlite/db/journal.sql";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");

            
        } catch (SQLException e) {
            //throw new Exception(e.getMessage());
        	PrintHelper.out("Errore di connessione", e.getMessage());
        } 
        
        return conn;
    }


}
