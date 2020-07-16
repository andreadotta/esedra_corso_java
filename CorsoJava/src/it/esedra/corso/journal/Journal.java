package it.esedra.corso.journal;

/**
 * Classe base dell'applicazione
 *  
 * @author bauhausk
 *
 */
public class Journal {

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/journal.sql";
	private Chapter[] chapters;

	private Author author;
	
	public Journal() {

	}

}
