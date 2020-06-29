package it.esedra.corso.marco;

import java.util.Calendar;
import java.util.Date;

public class TimeClient {

	public static void main(String[] args) {

		Calendar calend = Calendar.getInstance();
		Date now = new Date();

		now = new Date();
		calend.setTime(now);
		it.esedra.corso.marco.Time yourTimeNow = new it.esedra.corso.marco.Time();

		yourTimeNow.setTime(calend.get(Calendar.HOUR_OF_DAY), calend.get(Calendar.MINUTE), calend.get(Calendar.SECOND),
				calend.get(Calendar.MILLISECOND));

		System.out.println(yourTimeNow.getTime());

	}

}
