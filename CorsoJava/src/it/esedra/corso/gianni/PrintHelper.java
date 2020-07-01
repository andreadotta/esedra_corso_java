package it.esedra.corso.gianni;

import java.util.Calendar;

import java.util.Date;

import it.esedra.corso.libs.*;

public class PrintHelper {

	public static void print() {
		final String msg = null;
		final String stringa = ".";
		
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		cal.setTime(now);
		Time time = new Time();		
		
		time.setHours(cal.get(Calendar.HOUR_OF_DAY));
		time.setMinutes(cal.get(Calendar.MINUTE));
		time.setSeconds(cal.get(Calendar.SECOND));
		time.setMilliseconds(cal.get(Calendar.MILLISECOND));
		
		System.out.println("[" + time.getTime() + "]" + "-" + msg + "-" + stringa);
		
	}

}
