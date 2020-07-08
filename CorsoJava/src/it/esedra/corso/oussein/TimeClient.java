package it.esedra.corso.oussein;

import java.util.Calendar;
import java.util.Date;

import it.esedra.corso.libs.Time;

public class TimeClient {

	public static void main(String[] args) {

		Date ora = new Date();
		ora = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(ora);

		Time yourTimeNow = new Time();

		yourTimeNow.setHours(cal.get(Calendar.HOUR_OF_DAY));
		yourTimeNow.setMinutes(cal.get(Calendar.MINUTE));
		yourTimeNow.setSeconds(cal.get(Calendar.SECOND));
		yourTimeNow.setMilliseconds(cal.get(Calendar.MILLISECOND));

		System.out.println(yourTimeNow.getTime());
		System.out.println(Time.getCurrentTime());

	}

}
