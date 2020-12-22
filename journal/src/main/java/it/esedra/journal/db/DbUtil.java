package it.esedra.journal.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

	public DbUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Ricostruisce il database journal
	 * 
	 * @throws IOException
	 */
	public static void rebuildDb() throws IOException {

		try {
			// Carichiamo il percorso assoluto del file del database
			String dbpath = System.getProperty("user.dir") + JournalDbConnect.loadProperties().getDbpath();
			// cancella il database vecchio
			File oldDb = new File(dbpath); // File fornisce varie operazioni per manipolare
											// file già esistenti.
											// Non può leggere dati dal file
											// Consente ad esempio di cancellare un file, rinominarlo, etc

			oldDb.delete();

			// Crea il nuovo database
			// in SQLITE creando una connessione al db se questo non esiste
			// SQLITE lo crea
			Connection conn = JournalDbConnect.connect();

			// Carica tutte le tabelle
			List<String> tables = new ArrayList<String>();
			tables.add("author");
			tables.add("paragraph");
			tables.add("user");
			tables.add("video");
			tables.add("image");
			tables.add("chapter");
			tables.add("journal");

			for (String table : tables) {
				FileReader input = new FileReader(System.getProperty("user.dir") + "/sqlite/db/sql/" + table + ".sql");

				String sql = readFile(input);
				Statement stmt = conn.createStatement();

				stmt.executeUpdate(sql);
				stmt.close();
			}

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static String readFile(FileReader f) {
		String fileReaded = new String();
		try {

			BufferedReader b = new BufferedReader(f);

			String s;
			while (true) {
				s = b.readLine();
				if (s == null) {
					break;
				}
				fileReaded += s;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return fileReaded;

	}

}
