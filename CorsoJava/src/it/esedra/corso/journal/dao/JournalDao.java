package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.collections.JournalCollection;

public class JournalDao implements DaoInterface<Journal> {

	private Journal journal;
	private Connection conn;

	public JournalDao(Journal journal) {
		super();
		this.journal = journal;
	}

	@Override
	public Collection<Journal> getAll() {
		// istanzia una lista vuota di Journal
		Collection<Journal> journals = new JournalCollection();
		try {

			// crea lo statement
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM journal");

			// ottiene il result set
			while (rs.next()) {
				// e quindi per ogni tupla crea un oggetto di tipo Journal
				Journal journal = new Journal();
				// inserisce i dati nelle proprietà dell'oggetto
				journal.setId(rs.getInt("id"));
				journal.setName(rs.getString("name"));
				// aggiunge l'oggetto alla lista
				journals.add(journal);
			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore journal dao", e.getMessage());
		}
		// restituisce la lista
		return journals;

	}

	@Override
	public Journal update() {

		if (journal == null) {
			PrintHelper.out("journal non può essere null.");
			return null;
		}

		Journal journalCheck = this.get();
        Journal copy = null;
		try {
			if (journalCheck != null) {
				String sql = "UPDATE journal SET name= ? WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, journal.getName());
				stm.setInt(2, journal.getId());

				if (stm.executeUpdate()> 0) {

				stm.close();
				}
			} else {
				String sql = "INSERT INTO journal (id, name) VALUES (?,?) ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setInt(1, journal.getId());
				stm.setString(2, journal.getName());

				if (stm.executeUpdate() > 0) {;
				ResultSet genKeys = stm.getGeneratedKeys();
				if (genKeys.next()) {
					journal.setId(genKeys.getInt(1));
				}
				}
				stm.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore journal dao", e.getMessage());
		}

		return copy;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public Journal get() {
		// inizializza un nuovo oggetto Journal
		Journal journal = null;

		try {

			// crea lo statement
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM journal WHERE id =" + this.journal.getId());

			while (rs.next()) {
				// istanzia l'elemento Journal
				journal = new Journal();

				journal.setId(rs.getInt("id"));
				journal.setName(rs.getString("name"));

			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore journal dao", e.getMessage());
		}
		// restituisce l'oggetto
		return journal;

	}

	@Override
	public boolean delete() {

		boolean success = true;

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM journal WHERE id = " + this.journal.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (Exception e) {
			PrintHelper.out("Errore journal dao", e.getMessage());
		}

		return success;
	}

}
