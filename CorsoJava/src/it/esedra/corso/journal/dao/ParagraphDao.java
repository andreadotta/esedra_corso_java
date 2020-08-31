package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.collections.ParagraphCollection;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.collections.AuthorCollection;

public class ParagraphDao implements DaoInterface<Paragraph> {

	private Paragraph paragraph;
	private Connection conn;

	public ParagraphDao(Paragraph paragraph) {
		super();
		this.paragraph = paragraph;
	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

	}

	@Override
	public Collection<Paragraph> getAll() {
		Collection<Paragraph> paragraphs = new ParagraphCollection();
		
		//List<Paragraph> paragraphs = new ArrayList<>();
		try {

			Statement stm = this.conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM Paragraph");

			while (rs.next()) {

				Paragraph paragraph = new Paragraph();

				paragraph.setText(rs.getString("Text"));
				paragraph.setId(rs.getInt("id"));

				paragraphs.add(paragraph);
			}

			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore user dao", e.getMessage());
		}

		return (Collection<Paragraph>) paragraphs;

	}

	@Override
	public void setConnection(Connection con) {

	}

}
