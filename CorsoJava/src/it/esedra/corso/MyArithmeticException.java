package it.esedra.corso;

import java.io.PrintStream;

public class MyArithmeticException extends Exception {


	public MyArithmeticException(String msg) {
		try {
			String destination = System.getProperty("user.dir") + "/error.txt";
			PrintStream errorStream = new PrintStream(destination);	
			super.printStackTrace(errorStream);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
