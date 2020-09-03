package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;

import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.collections.ParagraphCollection;

public class ParagraphDao implements DaoInterface<Paragraph> {

	private Paragraph paragraph;
	private Connection conn;

	public ParagraphDao(Paragraph paragraph) {
		super();
		this.paragraph = paragraph;
	}

	@Override
	public void update() {
		if (paragraph == null) {
			PrintHelper.out("Paragraph non può essere null");
			return;
		}

	}

	@Override
	public void delete() {

	}

	@Override
	public Collection<Paragraph> getAll() {
		Collection<Paragraph> paragraphs = new ParagraphCollection();

		// List<Paragraph> paragraphs = new ArrayList<>();
		try {

			Statement stm = this.conn.createStatement();
			stm.executeUpdate("INSERT INTO paragraph (id, text) VALUES ( " + paragraph.getId() + ", '"
					+ paragraph.getText() + "', '" + "' )");

			conn.close();
		} catch (Exception e) {
			PrintHelper.out("Errore paragraph dao", e.getMessage());
		}

		return (Collection<Paragraph>) paragraphs;

	}

	@Override
	public void setConnection(Connection con) {

	}

}
