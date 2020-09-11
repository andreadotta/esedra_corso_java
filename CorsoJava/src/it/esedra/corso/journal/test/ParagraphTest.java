package it.esedra.corso.journal.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.Video;
import it.esedra.corso.journal.collections.ParagraphCollection;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.dao.ParagraphDao;
import it.esedra.corso.journal.dao.VideoDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

public class ParagraphTest {
	public static final int ID = 1;
	public static final String TEXT = "il primo paragraph del diario";

	public void testUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Paragraph paragraph = new Paragraph();
			paragraph.setId(ID);
			paragraph.setText(TEXT);

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
			boolean found = false;
			while (paragraphIterator.hasNext()) {

				Paragraph paragraph = paragraphIterator.next();

				PrintHelper.out("id: " + paragraph.getId());
				PrintHelper.out("text: " + paragraph.getText());
				if (paragraph.getId() == ID && paragraph.getText().equals(TEXT)) {
					found = true;
					break;

				}
				

			
			}
			connection.close();
			if(found == true) {
				PrintHelper.out(JournalTest.TEST_OK);
				
			}else {
				PrintHelper.out(JournalTest.TEST_FAIL);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			DbUtil.rebuildDb();
			ParagraphTest ct = new ParagraphTest();
			ct.testUpdate();
			ct.testGetAll();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void testGet() {

		try {

			Connection connection = JournalDbConnect.connect();
			Paragraph paragraphMock = new Paragraph();
			paragraphMock.setId(ID);
			ParagraphDao paragraphDao = new ParagraphDao(paragraphMock);
			paragraphDao.setConnection(connection);

			Paragraph paragraph = paragraphDao.get();

			connection.close();
			if (paragraph.getId() == ID) {
				PrintHelper.out(JournalTest.TEST_OK);

			} else {
				PrintHelper.out(JournalTest.TEST_FAIL);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}










