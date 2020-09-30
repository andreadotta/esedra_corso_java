package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.AuthorBuilder;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.ParagraphBuilder;
import it.esedra.corso.journal.collections.ParagraphCollection;

public class ParagraphDao implements DaoInterface<Paragraph> {

	private Paragraph paragraph;
	private Connection conn;

	public ParagraphDao() {

	}

	public ParagraphDao(Paragraph paragraph) {
		super();
		this.paragraph = paragraph;
	}

	@Override
	public Paragraph update() {

		if (paragraph == null) {
			PrintHelper.out("Paragraph non può essere null");
			return null;
		}
		Paragraph paragraphCheck = this.get();
		Paragraph copy = null;
		try {
			if (paragraphCheck != null) {
				String sql = "UPDATE paragraph SET text= ? WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, paragraph.getText());
				stm.setInt(2, paragraph.getId());

				if (stm.executeUpdate() > 0) {
					copy = new ParagraphBuilder().setId(paragraph.getId()).setText(paragraph.getText()).build();
				}

				stm.close();

			} else {
				String sql = "INSERT INTO paragraph ( text) VALUES (?) ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);


				if (stm.executeUpdate() > 0) {
					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {

					stm.setString(1, paragraph.getText());
					copy = new ParagraphBuilder().setId(genKeys.getInt(1)).setText(paragraph.getText()).build();
					}

				}

				stm.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore paragraph dao", e.getMessage());
		}

		return copy;

	}

	@Override
	public Collection<Paragraph> getAll() {
		Collection<Paragraph> paragraphs = new ParagraphCollection();

		// List<Paragraph> paragraphs = new ArrayList<>();
		try {

			Statement stm = this.conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM Paragraph");

			while (rs.next()) {
				Paragraph paragraph = new ParagraphBuilder().setId(rs.getInt("id")).setText(rs.getString("text"))
						.build();

				paragraphs.add(paragraph);
			}

			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore paragraph dao", e.getMessage());
		}

		return  paragraphs;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;

	}

	@Override
	public boolean delete() {

		boolean success = true;

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM paragraph WHERE id = " + this.paragraph.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (Exception e) {
			PrintHelper.out("Errore paragraph dao", e.getMessage());
		}

		return success;
	}

	@Override
	public Paragraph get() {
		Paragraph paragraph = null;

		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM paragraph WHERE id = " + this.paragraph.getId());

			while (rs.next()) {
				paragraph = new ParagraphBuilder().setId(rs.getInt("id")).setText(rs.getString("text")).build();

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore paragraph dao", e.getMessage());
		}
		return paragraph;
	}
}
