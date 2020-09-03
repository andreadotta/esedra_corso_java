package it.esedra.corso.journal.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.collections.ParagraphCollection;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.db.JournalDbConnect;

public class ParagraphTest {

	public void testUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Paragraph paragraph = new Paragraph();
			paragraph.setId(1);
			paragraph.setText("il primo paragraph del diario");

			ParagraphDao paragraphDao = new ParagraphDao(paragraph);
			paragraphDao.setConnection(connection);
			paragraphDao.update();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testGetAll() {

		Collection<Paragraph> paragraphs = new ParagraphCollection();

		try {
			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			ParagraphDao paragraphdao = new ParagraphDao(new Paragraph());
			paragraphdao.setConnection(connection);

			// Chiamata metodo getAll() sulla Collection creata
			Collection<Paragraph> paragraphsCollection = paragraphdao.getAll();

			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<Paragraph> paragraphIterator = paragraphsCollection.createIterator();

			// cicla sugli elementi Paragraph della paragraphCollection e restituisce per
			// ogni
			// elemento i valori delle colonne della tabella text

			while (paragraphIterator.hasNext()) {

				Paragraph paragraph = paragraphIterator.next();
				PrintHelper.out(" text: " + " " + paragraph.getText());

				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ParagraphTest ct = new ParagraphTest();
		ct.testUpdate();
		ct.testGetAll();
	}

}
