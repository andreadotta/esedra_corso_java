package it.esedra.corso.oussein;

import java.util.Calendar;
import java.util.Date;

public class TimeClient {
	private int Giorni;
	private int mese;
	private int anni;

	public static void main(String[] args) {

		Date ora = new Date();
		ora = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(ora);

		
		it.esedra.corso.oussein.Time yourTimeNow = new it.esedra.corso.oussein.Time();

		yourTimeNow.setHours(cal.get(Calendar.HOUR_OF_DAY));
		yourTimeNow.setMinutes(cal.get(Calendar.MINUTE));
		yourTimeNow.setSeconds(cal.get(Calendar.SECOND));
		yourTimeNow.setMilliseconds(cal.get(Calendar.MILLISECOND));

		System.out.println(yourTimeNow.getTime());

	}

	public void setDate(int j, int ms, int a) {

		this.setGiorni(j);
		this.setMese(ms);
		this.setAnni(a);

	}

	public int getGiorni() {
		return Giorni;
	}

	public void setGiorni(int j) {
		if (j < 24 && j >= 0) {
			this.Giorni = j;
		} else {
			
			this.Giorni = 0;
		}
	}

	public int getMese() {
		return mese;
	}

	public void setMese(int ms) {
		if (ms < 30 && ms >= 0) {
			this.mese = ms;
		} else {
			this.mese = 0;
		}
	}

	public int getAnni() {
		return anni;
	}

	public void setAnni(int a) {
		if (a < 365 && a >= 0) {
			this.anni = a;
		} else {
			this.anni = 0;
		}
	}

}
