package it.esedra.corso.journal.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.collections.ChapterCollection;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChapterTest {

	@Test	
	public void testAUpdate() {
		
		try {
			Connection connection = JournalDbConnect.connect();
			
			Chapter chapter = new Chapter();
			chapter.setId(1);
			chapter.setTitle("Capitolo di esempio");
			chapter.setDate(new Date());
			
			ChapterDao chapterDao = new ChapterDao(chapter);
			chapterDao.setConnection(connection);
			
			assertTrue(chapterDao.update() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetAll() {
		
		Collection<Chapter> cCollection = new ChapterCollection();

		try {
			// Effettua la connessione al database
			Connection connection = JournalDbConnect.connect();
			ChapterDao cpdao = new ChapterDao(new Chapter());
			cpdao.setConnection(connection);
						
			// Chiamata metodo getAll() sulla Collection creata
			cCollection = cpdao.getAll();
			
			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<Chapter> cIterator = cCollection.createIterator();
			
			// cicla sugli elementi User della userCollection e restituisce per ogni
			// elemento i valori delle colonne della tabella user
			while (cIterator.hasNext()) {
				Chapter chapter = cIterator.next();
				
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeClass
	public static void setup() {

		try {
			DbUtil.rebuildDb();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
