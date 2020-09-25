package it.esedra.corso.journal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;

import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.ChapterBuilder;
import it.esedra.corso.journal.collections.ChapterCollection;

public class ChapterDao implements DaoInterface<Chapter> {

	private Chapter chapter;

	private Connection conn;

	public ChapterDao(Chapter chapter) {
		super();
		this.chapter = chapter;
	}

	@Override
	public Chapter update() {
		if (chapter == null) {
			PrintHelper.out("author non può essere null.");
			return null;
		}
		Chapter chapterCheck = this.get();
		Chapter copy = null;
		try {
			if ((chapterCheck != null)) {
				String sql = "UPDATE chapter SET title = ?, date= ?  WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, chapter.getTitle());
				stm.setDate(2,new java.sql.Date( chapter.getDate().getTime()));
				stm.setInt(3, chapter.getId());

				 if (stm.executeUpdate() > 0) {
					copy = new ChapterBuilder().setId(chapter.getId()).setTitle(chapter.getTitle()).setDate(chapter.getDate()).build();
				 }
					stm.close();
			} else {
				String sql = "INSERT INTO chapter ( title, date ) VALUES (?, ?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);
 

				if (stm.executeUpdate() > 0) {
					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {

					stm.setString(1, chapter.getTitle());
					stm.setDate(2, (Date) chapter.getDate());
					copy = new ChapterBuilder().setId(genKeys.getInt(1)).setTitle(chapter.getTitle()).setDate(chapter.getDate()).build();
					}

				}

		
				stm.close();
			}
		} catch (Exception e) { 
			e.printStackTrace();
			PrintHelper.out("Errore author dao", e.getMessage());
		}
		return copy;

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

				Chapter chapter = new ChapterBuilder().setId(rs.getInt("id")).setTitle(rs.getString("title")).setDate(rs.getDate("date"))
						.build();

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
				chapter = new ChapterBuilder().setId(rs.getInt("id")).setTitle(rs.getString("title")).setDate(rs.getDate("date"))
						.build();

			}
				
			
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore video dao", e.getMessage());
		}
		return chapter;
	}

}