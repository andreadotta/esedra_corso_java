package it.esedra.corso.journal.test;

import java.sql.Connection;
import java.sql.SQLException;

import it.esedra.corso.collections.ParagraphCollection;
import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.db.DbConnect;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Paragraph;
import it.esedra.corso.journal.dao.ParagraphDao;

public class ParagraphTest {
	public static final String DBPATH = System.getProperty("paragraph.dir") + "/sqlite/db/oussein.db";


	public static void main(String[] args) {
		Collection<Paragraph> paragraphs = new ParagraphCollection();
		
		try {
			// Effettua la connessione al database
			
			Connection connection = DbConnect.connect(DBPATH);
			ParagraphDao paragraphdao = new ParagraphDao(new Paragraph());
			paragraphdao.setConnection(connection);
			
			// Chiamata metodo getAll() sulla Collection creata
			Collection<Paragraph> paragraphsCollection = paragraphdao.getAll();
			
			// Inizializzazione iterator per ciclare sulla Collection
			Iterator<Paragraph> paragraphIterator = paragraphsCollection.createIterator();
			
			// cicla sugli elementi Paragraph della paragraphCollection e restituisce per ogni
			// elemento i valori delle colonne della tabella text
			
			while (paragraphIterator.hasNext()) {
				
				Paragraph paragraph = paragraphIterator.next();
				PrintHelper.out(" text: "  + " " + paragraph.getText());
				

			connection.close();
		} }catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	
	
}
}
