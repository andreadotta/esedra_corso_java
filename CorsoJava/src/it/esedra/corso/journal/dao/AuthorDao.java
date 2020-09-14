package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.collections.AuthorCollection;

public class AuthorDao implements DaoInterface<Author> {

	private Author author;
	private Connection conn;

	public AuthorDao(Author author) {
		super();
		this.author = author;
	}

	@Override
	public int update() {
		int affectedRows = 0;
		if (author == null) {
			PrintHelper.out("author non può essere null.");
			return affectedRows;
		}
		try {
			Statement stm = this.conn.createStatement();
			affectedRows = stm.executeUpdate("INSERT INTO author (id, name,email) VALUES ( " + author.getId() + ", '"
			 +author.getName() + "', '" + author.getEmail() + "')");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore author dao", e.getMessage());
		}
		return affectedRows;
	}

	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public Collection<Author> getAll() {

		// istanzia una lista vuota di User
		Collection<Author> authors = new AuthorCollection();
		try {

			// crea lo statement
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM author");

			// ottiene il result set
			while (rs.next()) {
				// e quindi per ogni tupla crea un oggetto di tipo User
				Author author = new Author();
				// inserisce i dati nelle proprietÃ  dell'oggetto
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setEmail(rs.getString("email"));

				// aggiunge l'oggetto alla lista
				authors.add(author);
			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore user dao", e.getMessage());
		}
		// restituisce la lista
		return authors;
	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;

	}

	@Override
	public Author get() {
        Author author = null;
		
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM author WHERE id = " + this.author.getId());
			
			while (rs.next()) {
				
			    author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setEmail(rs.getString("email"));
				
			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore author dao", e.getMessage());
		}
		return author;
	}

}
