package it.esedra.corso.journal.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Author;
import it.esedra.corso.journal.Chapter;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.collections.AuthorCollection;
import it.esedra.corso.journal.dao.ChapterDao;
import it.esedra.corso.journal.dao.AuthorDao;
import it.esedra.corso.journal.db.DbUtil;
import it.esedra.corso.journal.db.JournalDbConnect;

public class AuthorTest {
	public static final int ID = 1;
	public static final String NAME = " Mbrain Linda";
    public static final String EMAIL = "info@mcbrain.com";
	public void testUpdate() {
		try {
			Connection connection = JournalDbConnect.connect();

			Author author = new Author();
			author.setId(ID);
			author.setText(NAME);
            author.setText(EMAIL);
            
			AuthorDao authorDao = new AuthorDao(author);
			authorDao.setConnection(connection);
			authorDao.update();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	

	public void testGetAll() {

		Collection<Author> author = new AuthorCollection();

		try {
			// Effettua la connessione al database

			Connection connection = JournalDbConnect.connect();
			AuthorDao authordao = new AuthorDao(new Author());
			authordao.setConnection(connection);

			// 
			Collection<Author> authorCollection = authordao.getAll();

			// 
			Iterator<Author> authorIterator = authorCollection.createIterator();

			
			boolean found = false;
			while (authorIterator.hasNext()) {

				Author author1 = authorIterator.next();

				PrintHelper.out("id: " + author1.getId());
				PrintHelper.out("NAME: " + author1.getName());
				PrintHelper.out("EMAIL: " + author1.getEmail());
				if (author1.getId() == ID && author1.getName().equals(NAME)) {
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
			AuthorTest ct = new AuthorTest();
			ct.testUpdate();
			ct.testGetAll();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
