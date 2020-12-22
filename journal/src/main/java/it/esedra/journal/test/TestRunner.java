package it.esedra.journal.test;

import java.io.File;
import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import it.esedra.journal.db.JournalDbConnect;
import it.esedra.journal.log.JournalLogger;

public class TestRunner {

	public static void main(String[] args) {

		String dbpath;
		try {
			JournalLogger.setup();
			dbpath = System.getProperty("user.dir") + JournalDbConnect.loadProperties().getDbpath();
			// cancella il database vecchio
			File oldDb = new File(dbpath); // File fornisce varie operazioni per manipolare
											// file già esistenti.
											// Non può leggere dati dal file
											// Consente ad esem,pio di cancellare un file, rinominarlo, etc
			oldDb.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Result result = JUnitCore.runClasses(AllTests.class);

		for (Failure failure : result.getFailures()) {

			System.out.println(failure.toString());

		}

		System.out.println(TestRunner.class + " " + result.wasSuccessful());
	}

}
