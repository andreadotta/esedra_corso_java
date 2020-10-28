package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Journal;
import it.esedra.corso.journal.JournalBuilder;
import it.esedra.corso.journal.collections.JournalCollection;
import it.esedra.corso.journal.execeptions.DaoException;

public class JournalDao implements DaoInterface<Journal> {

	private Journal journal;
	private Connection conn;

	public JournalDao() {
		
	}
	
	public JournalDao(Journal journal) {
		super();
		this.journal = journal;
	}

	@Override
	public Collection<Journal> getAll() throws DaoException {
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
				Journal journal = new JournalBuilder().setId(rs.getInt("id")).setName(rs.getString("Name")).build();
				// aggiunge l'oggetto alla lista
				journals.add(journal);
			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (SQLException e) {
			throw new DaoException("Errore durante Delete Journal", e);
		}
		// restituisce la lista
		return journals;

	}

	@Override
	public Journal update() throws DaoException {

		if (journal == null) {
			PrintHelper.out("journal non può essere null.");
			return null;
		}

		Journal journalCheck = this.get();
		Journal copy = null;
		try {
			if (journalCheck != null) {
				String sql = "UPDATE journal SET name = ? WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, journal.getName());
				stm.setInt(2, journal.getId());

				if (stm.executeUpdate() > 0) {

					stm.close();
				}
			} else {
				String sql = "INSERT INTO journal (name) VALUES (?) ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, journal.getName());

				if (stm.executeUpdate() > 0) {
					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {
						copy = new JournalBuilder().setId(genKeys.getInt(1)).setName(journal.getName()).build();
					}
				}

				stm.close();

			}

		} catch (SQLException e) {
			throw new DaoException("Errore durante Delete Journal", e);
		}

		return copy;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public Journal get() throws DaoException {
		// inizializza un nuovo oggetto Journal
		Journal journal = null;

		try {

			// crea lo statement
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM journal WHERE id =" + this.journal.getId());

			while (rs.next()) {
				// istanzia l'elemento Journal
				journal = new JournalBuilder().setId(rs.getInt("id")).setName(rs.getString("Name")).build();

			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (SQLException e) {
			throw new DaoException("Errore durante Delete Journal", e);
		}
		// restituisce l'oggetto
		return journal;

	}

	@Override
	public boolean delete() throws DaoException {

		boolean success = true;

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM journal WHERE id = " + this.journal.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (SQLException e) {
			throw new DaoException("Errore durante Delete Journal", e);
		}

		return success;
	}

}
