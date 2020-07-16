package it.esedra.corso.journal.db;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class JournalDbConnectTest {

	@Test
	void test() {
		try {
			JournalDbConnect.connect();	
			assumeTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
			
			
		}


	}

}
