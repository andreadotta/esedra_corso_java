package it.esedra.corso.oussein;

import it.esedra.corso.libs.Time;

public class PrintHelper {

	public static void out(String info, String out) {

		Time ora = new Time();

		if (info == null) {
			System.out.println("[" + ora.getCurrentTime() + "]" + "-" + out);

		} else {
			System.out.println("[" + ora.getCurrentTime() + "]" + "-" + info + "-" + out);
		}

	}
}
