package it.esedra.corso.journal.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.journal.Journal;

public class DbUtil {

	public DbUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void rebuildDb() throws IOException {

		try {
			String dbpath = System.getProperty("user.dir") + Journal.loadProperties().getDbpath();
			// cancella il database vecchio
			File oldDb = new File(dbpath);
			oldDb.delete();
			// crea il nuovo database
			Connection conn = JournalDbConnect.connect();
			
			// caricherei tutte le tabelle
			List<String> tables = new ArrayList<String>();
			tables.add("author");
			tables.add("paragraph");
			tables.add("user");
			tables.add("video");

			for (String table : tables) {
				FileReader input = new FileReader(System.getProperty("user.dir") + "/sqlite/db/sql/" + table + ".sql");

				String sql = readFile(input);
				Statement stmt = conn.createStatement();

				stmt.executeUpdate(sql);
				stmt.close();
			}

			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String readFile(FileReader f) {
		String fileReaded = new String();
		try {

			BufferedReader b;
			b = new BufferedReader(f);

			String s;

			while (true) {

				s = b.readLine();

				if (s == null)
					break;
				fileReaded += s;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileReaded;

	}

}
