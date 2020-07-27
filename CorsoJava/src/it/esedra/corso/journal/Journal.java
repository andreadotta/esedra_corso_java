
package it.esedra.corso.journal;

/**
 * Classe base dell'applicazione
 *  
 * @author bauhausk
 *
 */
public class Journal {

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/journal.sql";
	

	private Author author;
	
	public Journal() {

	}

}
=======
package it.esedra.corso.journal;

/**
 * Classe base dell'applicazione
 *  
 * @author bauhausk
 *
 */
public class Journal {

	public static final String DBPATH = System.getProperty("user.dir") + "/sqlite/db/journal.sql";
	private Chapter[] chapters;

	private Author author;
	
	public Journal() {

	}
}

>>>>>>> branch 'master' of https://github.com/andreadotta/esedra_corso_java.git
