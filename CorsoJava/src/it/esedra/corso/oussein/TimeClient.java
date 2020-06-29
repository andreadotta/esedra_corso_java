package it.esedra.corso.oussein;

import java.util.Calendar;
import java.util.Date;

public class TimeClient {

	public static void main(String[] args) {
		

		Date ora = new Date();
		ora = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(ora);

		it.esedra.corso.oussein.Time ousseinTime = new it.esedra.corso.oussein.Time();
		ousseinTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(ousseinTime.getTime());

	}

}
