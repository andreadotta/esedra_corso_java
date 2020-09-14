package it.esedra.corso.journal.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import it.esedra.corso.helpers.PrintHelper;

public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(AllTests.class);
		
		for (Failure failure : result.getFailures()) {
			
			PrintHelper.out(failure.toString());
			
		}
		
		PrintHelper.out(TestRunner.class +  " " + result.wasSuccessful());
	}

}
