package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;

import it.esedra.corso.journal.Chapter;

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
			PrintHelper.out("author non può essere null.");
			return affectedRows;
		}
		Chapter chapterCheck = this.get();
		try {
			if ((chapterCheck != null)) {
				String sql = "UPDATE chapter SET title = ?, date= ?  WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, chapter.getTitle());
				stm.setDate(2,new java.sql.Date( chapter.getDate().getTime()));
				stm.setInt(3, chapter.getId());

				affectedRows = stm.executeUpdate();
				stm.close();
			} else {
				String sql = "INSERT INTO chapter ( title, date ) VALUES (?, ?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, chapter.getTitle());
				stm.setDate(2,new java.sql.Date( chapter.getDate().getTime()));
				affectedRows = stm.executeUpdate();
				ResultSet genKeys = stm.getGeneratedKeys();
				if (genKeys.next()) {
					chapter.setId(genKeys.getInt(1));
				}

				stm.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			PrintHelper.out("Errore author dao", e.getMessage());
		}
		return affectedRows;

	}

	@Override
	public boolean delete() {

		 boolean success = true;
			
			try {
				Statement stm = this.conn.createStatement();
				int rs = stm.executeUpdate("DELETE FROM chapter WHERE id = " + this.chapter.getId());
				
				if(rs > 0) {
					success = true;
				}
			} catch (Exception e) {
				PrintHelper.out("Errore author dao", e.getMessage());
			}
			
		return success;
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