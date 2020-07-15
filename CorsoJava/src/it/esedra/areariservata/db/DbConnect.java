package it.esedra.areariservata.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	/**
	 * Connect to a sample database
	 */
	public static void connect() throws Exception {
		Connection connection;
		Statement statement;
		ResultSet result;
		Connection conn = null;
		try {
			// db parameters
			connection = DriverManager.getConnection("jdbc:sqlite://localhost/cooperative", "root", "");
			// create a connection to the database
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT nom,prenom,sexe,birthday,ville FROM cooperative");
			while (result.next())
				;
			System.out.println("nom:" + result.getString("nom") + "prenom:" + result.getString("prenom") + "sexe:"
					+ result.getString("sexe") + "birthday:" + result.getString("birthday") + "ville"
					+ result.getString("ville"));

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
