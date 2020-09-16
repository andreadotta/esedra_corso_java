package it.esedra.corso.oussein.JUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import it.esedra.corso.helpers.PrintHelper;


public class TestRunner {

	public static void main(String[] args) {
	Result result = JUnitCore.runClasses(TestOperaiDetail.class);
		
		for (Failure failure : result.getFailures()) {
			
			PrintHelper.out(failure.toString());
			
		}
		
		PrintHelper.out(TestRunner.class +  " " + result.wasSuccessful());
	}

	}


