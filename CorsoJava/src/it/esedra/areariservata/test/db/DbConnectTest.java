package it.esedra.areariservata.test.db;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import it.esedra.areariservata.db.DbConnect;

class DbConnectTest {

	@Test
	void test() {
		try {
			DbConnect.connect();	
			assumeTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
		}


	}

}
