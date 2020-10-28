package it.esedra.corso.gianni;

import java.util.Calendar;
import java.util.Date;
import it.esedra.corso.libs.Time;

/**
 * Questa classe utilizza Time e restituisce l'orario corrente.
 * 
 * @author gpaol
 *
 */

public class TimeClient {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		cal.setTime(now);
		Time gianniTime = new Time();
		gianniTime.setHours(cal.get(Calendar.HOUR_OF_DAY));
		gianniTime.setMinutes(cal.get(Calendar.MINUTE));
		gianniTime.setSeconds(cal.get(Calendar.SECOND));
		gianniTime.setMilliseconds(cal.get(Calendar.MILLISECOND));
		System.out.println(gianniTime.getTime());
		System.out.println(Time.getCurrentTime());

	}

}
