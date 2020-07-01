package it.esedra.corso.oussein;

import it.esedra.corso.libs.Time;

public class PrintHelper {
	
	private static String info;

static {

		
		info = "Current time is: ";
		
}

	public static void out(String info,String out) {
		
		
		
		
		Time ora = new Time();

		if (info == null) {
			System.out.println("[" + ora.getTime() + "]" + "-" + out);

		} else {
			System.out.println("[" + ora.getTime() + "]" + "-" + info + "-" + out);
		}
	
	}
}
