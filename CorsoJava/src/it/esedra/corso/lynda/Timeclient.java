package it.esedra.corso.lynda;

import java.util.Calendar;
import java.util.Date;

public class Timeclient {

	public Timeclient() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);

 Time lyndaTime = new Time ();
 lyndaTime.setHours (cal.get(Calendar.HOUR_OF_DAY));
 
 lyndaTime.setMinutes (cal.get(Calendar.MINUTE));
 
 lyndaTime.setSeconds  (cal.get(Calendar.SECOND));
 
 lyndaTime.setMilliseconds (cal.get(Calendar.MILLISECOND));
   System.out.println(lyndaTime.getTime());
	}
	
}
