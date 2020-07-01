package it.esedra.corso.gianni;

import it.esedra.corso.libs.*;

public class PrintHelper {

	public static void out(String msg, String out) {

		if (msg == null) {
			System.out.println("[" + time.getCurrentTime() + "] " + "- " + out);

		} else {
			System.out.println("[" + time.getCurrentTime() + "] " + "- " + msg + " - " + out);
		}

	}

}
