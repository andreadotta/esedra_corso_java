package it.esedra.corso.marco;

import it.esedra.corso.libs.Time;

public class PrintHelper {
	
	public static void out(String info, String out) {

		if (info == null) {
			System.out.println("[" + Time.getCurrentTime() + "]" + "-" + out);

		} else {
			System.out.println("[" + Time.getCurrentTime() + "]" + "-" + info + "-" + out);
		}

	}
	
}
