package it.esedra.areariservata.test.db;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import it.esedra.corso.db.DbConnect;

class DbConnectTest {

	@Test
	void test() {
		try {
			Connection con = DbConnect.connect("/path");	
			assumeTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
		}


	}

}
