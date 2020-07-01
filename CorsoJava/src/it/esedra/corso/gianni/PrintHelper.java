package it.esedra.corso.gianni;

import it.esedra.corso.libs.*;

public class PrintHelper {

	public static void out(String msg, String out) {
		Time time = new Time();

		if (msg == null) {
			System.out.println("[" + time.getTime() + "]" + "-" + out);

		} else {
			System.out.println("[" + time.getTime() + "]" + "-" + msg + "-" + out);
		}

	}

}
