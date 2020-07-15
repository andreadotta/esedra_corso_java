package it.esedra.areariservata.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	/**
     * Connect to a sample database
     */
    public static void connect() throws Exception {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/home/bauhausk/workspace-java/AreaRiservata/sqlite/db/areariservata";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");

            
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }


}
