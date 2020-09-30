package it.esedra.corso.marco;

import java.util.Calendar;
import it.esedra.corso.libs.Time;
import java.util.Date;

public class TimeClient {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		Date now = new Date();

		cal.setTime(now);
		Time marcoTime = new Time();

		marcoTime.setHours(cal.get(Calendar.HOUR_OF_DAY));
		marcoTime.setMinutes(cal.get(Calendar.MINUTE));
		marcoTime.setSeconds(cal.get(Calendar.SECOND));
		marcoTime.setMilliseconds(cal.get(Calendar.MILLISECOND));

		System.out.println(marcoTime.getTime());

		System.out.println(Time.getCurrentTime());

	}

}
