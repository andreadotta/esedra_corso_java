package it.esedra.corso.lynda;

import java.util.Calendar;
import java.util.Date;

import it.esedra.corso.libs.Time;

public class TimeClient {
	
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		Date now = new Date();

		cal.setTime(now);
		Time time = new Time();

		time.setHours(cal.get(Calendar.HOUR_OF_DAY));
		time.setMinutes(cal.get(Calendar.MINUTE));
		time.setSeconds(cal.get(Calendar.SECOND));
		time.setMilliseconds(cal.get(Calendar.MILLISECOND));

		System.out.println(time.getTime());
		
		System.out.println(Time.getCurrentTime());

	}

}