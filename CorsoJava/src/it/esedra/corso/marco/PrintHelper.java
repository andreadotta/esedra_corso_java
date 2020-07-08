<<<<<<< HEAD
package it.esedra.corso.marco;

import java.util.Calendar;
import java.util.Date;

import it.esedra.corso.libs.Time;

public class PrintHelper {

	private static String stringa;
	private static String messaggio;
	
	static {

		stringa = "stringa di prova";
		messaggio = null;

	}

	public static void printOut(String printOut) {

		Calendar cal = Calendar.getInstance();
		Date now = new Date();

		cal.setTime(now);
		Time marcoTime = new Time();

		marcoTime.setHours(cal.get(Calendar.HOUR_OF_DAY));
		marcoTime.setMinutes(cal.get(Calendar.MINUTE));
		marcoTime.setSeconds(cal.get(Calendar.SECOND));
		marcoTime.setMilliseconds(cal.get(Calendar.MILLISECOND));

		printOut = Time.getCurrentTime() + " - " + messaggio + " - " + stringa;
		System.out.println(printOut);

	}

}
=======
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
>>>>>>> branch 'master' of https://github.com/andreadotta/esedra_corso_java.git
