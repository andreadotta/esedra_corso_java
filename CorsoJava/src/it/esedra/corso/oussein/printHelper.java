package it.esedra.corso.oussein;

import it.esedra.corso.libs.Time;

public class printHelper {

	public static void out(String info, String out) {
		
		Time Ora = new Time();

		if (info == null) {
			System.out.println("[" + Ora.getTime() + "]" + "-" + out);

		} else {
			System.out.println("[" + Ora.getTime() + "]" + "-" + info + "-" + out);
		}
	}
}