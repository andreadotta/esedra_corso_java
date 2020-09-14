package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.collections.ChapterCollection;

public class ChapterDao implements DaoInterface<Chapter> {

	private Chapter chapter;

	private Connection conn;

	public ChapterDao(Chapter chapter) {
		super();
		this.chapter = chapter;
	}

	@Override
	public int update() {
		int affectedRows = 0;
		if (chapter == null) {
			PrintHelper.out("Chapter non può essere null");
			return affectedRows;
		}
		try {
			Statement stm = this.conn.createStatement();
			affectedRows = stm.executeUpdate("INSERT INTO chapter (id, title, date) VALUES ( " + chapter.getId() + ", '"
					+ chapter.getTitle() + "', '" + chapter.getDate() + "' )");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore chapter dao", e.getMessage());
		}
		
		return affectedRows;
	}

	@Override
	public boolean delete() {
		
		return false;

	}

	@Override
	public Collection<Chapter> getAll() {

		Collection<Chapter> chapters = new ChapterCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM chapter");

			while (rs.next()) {

				Chapter chapter = new Chapter();
				chapter.setId(rs.getInt("id"));
				chapter.setTitle(rs.getString("title"));
				chapters.add(chapter);

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}

		return chapters;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public Chapter get() {
		Chapter chapter = null;

		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM chapter WHERE id = " + this.chapter.getId());

			while (rs.next()) {

				chapter = new Chapter();
				chapter.setId(rs.getInt("id"));
				chapter.setTitle(rs.getString("title"));

			}
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}
		return chapter;
	}

}