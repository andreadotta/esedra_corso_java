package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class Snippet0109 {

	public Snippet0109() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// SYSTEM PROPERTIES
		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

		// User working directory
		PrintHelper.out(System.getProperty("user.dir"));
		// windows: \ c:\Program files\qualcosa unix: / /usr/local/qualcosa
		PrintHelper.out(System.getProperty("file.separator"));
		//
		PrintHelper.out(System.getProperty("java.class.path"));
		//
		PrintHelper.out(System.getProperty("java.version"));
		//
		PrintHelper.out(System.getProperty("os.name"));
		//
		PrintHelper.out(System.getProperty("line.separator"));
		//
		PrintHelper.out(System.getProperty("java.home"));
	}

}
