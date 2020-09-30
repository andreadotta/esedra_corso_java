package it.esedra.corso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import it.esedra.corso.helpers.PrintHelper;

interface Debuggable {

	public enum Destination {File, Console};
	
	public default void debugOnFile(String file, String message) {
		debug(Destination.File, file, message);
	}
	
	public default void debugOnConsole(String message) {
		debug(Destination.Console, null, message);
	}

	private void debug(Destination dest, String file, String message) {
		switch (dest) {
		case File: 
			try {
				Files.write(Paths.get("./" + file), message.getBytes());
			} catch (IOException e) {
				PrintHelper.out(e.getMessage());
			}
			break;
		case Console: 
			PrintHelper.out(message);
			break;
		}
	}
}
