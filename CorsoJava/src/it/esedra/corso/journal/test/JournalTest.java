package it.esedra.corso.journal.test;

import java.io.IOException;

import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.journal.Config;
import it.esedra.corso.journal.Journal;

public class JournalTest {
 public static final String TEST_OK = "passed";
 public static final String TEST_FAIL = "failed";
	public JournalTest() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		Config conf;
		try {
			
			conf = Journal.loadProperties();
			
			if (conf == null) {
				PrintHelper.out("Errore");
			} else {
				PrintHelper.out("OK");
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
}
