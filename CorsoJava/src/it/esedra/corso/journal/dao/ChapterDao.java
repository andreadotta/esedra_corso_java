package it.esedra.corso.journal.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.ChapterBuilder;
import it.esedra.corso.journal.collections.ChapterCollection;
import it.esedra.corso.journal.execeptions.DaoException;

public class ChapterDao implements DaoInterface<Chapter> {

	private Chapter chapter;

	private Connection conn;

public ChapterDao() {
		
	}
	
	public ChapterDao(Chapter chapter) {
		super();
		this.chapter = chapter;
	}

	@Override
	public Chapter update() throws DaoException {
		
		if (chapter == null) {
			PrintHelper.out("chapter non può essere null.");
			return null;
		}
		Chapter chapterCheck = this.get();
		Chapter copy = null;
		try {
			if ((chapterCheck != null)) {
				String sql = "UPDATE chapter SET title = ?, date= ?  WHERE id = ? ;";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, chapter.getTitle());
				stm.setString(2, chapter.getDate());
				stm.setInt(3, chapter.getId());
				
				if (stm.executeUpdate() > 0) {
					
				stm.close();
				} 		
			} else {
				String sql = "INSERT INTO chapter ( title, date ) VALUES (?, ?);";
				PreparedStatement stm = this.conn.prepareStatement(sql);

				stm.setString(1, chapter.getTitle());
				stm.setString(2, chapter.getDate());

				if (stm.executeUpdate() > 0) {
					ResultSet genKeys = stm.getGeneratedKeys();
					if (genKeys.next()) {

						stm.setString(1, chapter.getTitle());
						stm.setString(2, chapter.getDate());
						copy = new ChapterBuilder().setId(genKeys.getInt(1)).setTitle(chapter.getTitle())
								.setDate(chapter.getDate()).build();
				
				}

				stm.close();
				
				}
				
			}
		
		} catch (SQLException e) {
			throw new DaoException("Errore durante Update Chapter", e);
		}
		return copy;

	}

	@Override
	public boolean delete() throws DaoException {

		boolean success = true;

		try {
			Statement stm = this.conn.createStatement();
			int rs = stm.executeUpdate("DELETE FROM chapter WHERE id = " + this.chapter.getId());

			if (rs > 0) {
				success = true;
			}
		} catch (SQLException e) {
			throw new DaoException("Errore durante Delete Chapter", e);
		}

		return success;
	}

	@Override
	public Collection<Chapter> getAll() throws DaoException {

		Collection<Chapter> chapters = new ChapterCollection();
		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM chapter");

			while (rs.next()) {
				Chapter chapter = new ChapterBuilder()
						.setId(rs.getInt("id"))
						.setTitle(rs.getString("title"))
						.setDate(rs.getString("date"))
						.build();

				chapters.add(chapter);
			}

			rs.close();
			
		} catch (SQLException e) {
			throw new DaoException("Errore durante GetAll Chapter", e);
		}

		return chapters;

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}

	@Override
	public Chapter get() throws DaoException {
		Chapter chapter = null;

		try {
			Statement stm = this.conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM chapter WHERE id = " + this.chapter.getId());

			while (rs.next()) {
				chapter = new ChapterBuilder()
						.setId(rs.getInt("id"))
						.setTitle(rs.getString("title"))
						.setDate(rs.getString("date"))
						.build();

			}

			rs.close();
		} catch (SQLException e) {
			throw new DaoException("Errore durante Get Chapter", e);
		}
		return chapter;
	}

}