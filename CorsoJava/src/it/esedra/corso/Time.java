package it.esedra.corso;

import java.util.Calendar;
import java.util.Date;

/**
 * In questa classe dovete creare 3 variabili di classe (proprietà)
 * 
 * hours minutes seconds
 * 
 * 
 * Quindi create un costruttore che inizializzi queste variabili a 0.
 * 
 * @author bauhausk
 *
 */
public class Time {

	public Time() {

		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);

		
		now = new Date();
		cal.setTime(now);
		it.esedra.corso.gianni.Time gianniTime = new it.esedra.corso.gianni.Time();
		gianniTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(gianniTime.getTime());

		now = new Date();
		cal.setTime(now);
		it.esedra.corso.lynda.Time lyndaTime = new it.esedra.corso.lynda.Time();
		lyndaTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(lyndaTime.getTime());
		
		now = new Date();
		cal.setTime(now);
		it.esedra.corso.samuel.Time samuelTime = new it.esedra.corso.samuel.Time();
		samuelTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(samuelTime.getTime());
		
		now = new Date();
		cal.setTime(now);
		it.esedra.corso.marco.Time marcoTime = new it.esedra.corso.marco.Time();
		marcoTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(marcoTime.getTime());
		

	}

}
