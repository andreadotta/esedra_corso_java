package it.esedra.corso.journal.test;

import java.io.IOException;

import it.esedra.corso.journal.db.DbUtil;

public class DbUtilTest {

	public DbUtilTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			DbUtil.rebuildDb();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
