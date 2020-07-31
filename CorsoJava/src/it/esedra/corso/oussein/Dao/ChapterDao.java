package it.esedra.corso.oussein.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.gianni.PrintHelper;
import it.esedra.corso.journal.Author;

import it.esedra.corso.journal.User;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.dao.DaoInterface;

public class ChapterDao implements DaoInterface<Chapter> {

	private Chapter chapter;
	private Connection conn;

	public ChapterDao(Chapter chapter) {
		super();
		this.chapter = chapter;
	}

	@Override
	public void update() {

	}

	@Override
	public void delete() {

	}

	@Override
	public List<Chapter> getAll() {
		List<Chapter> chapters = new ArrayList<>();
		try {

			// crea lo statemente
			Statement stm = this.conn.createStatement();
			// crea il result set al quale passa la query
			ResultSet rs = stm.executeQuery("SELECT * FROM chapter");

			// ottiene il result set
			while (rs.next()) {
				// e quindi per ogni tupla crea un oggetto di tipo User
				Chapter chapter = new Chapter();
				// inserisce i dati nelle proprietà dell'oggetto
				chapter.setNome(rs.getString("nome"));
				chapter.setCongnome(rs.getString("congnome"));
				chapter.setCitta(rs.getString("citta"));
				chapter.setProfessione(rs.getString("professione"));

				// aggiunge l'oggetto alla lista
				chapters.add(chapter);
			}
			// chiude le connessioni e il result set
			rs.close();
		} catch (Exception e) {
			PrintHelper.out("Errore chapter dao", e.getMessage());
		}
		// resituisce la lista

		return chapters;
	

	}

	@Override
	public void setConnection(Connection con) {
		this.conn = con;
	}
}