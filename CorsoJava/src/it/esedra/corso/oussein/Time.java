package it.esedra.corso.oussein;

import java.util.Calendar;
import java.util.Date;

public class Time {
//dicheriazione dei variablili di classe
	private int hours;
	private int minutes;
	private int seconds;
	private int milliseconds;
	/*
	 * creazione di un classe proprieta con parametri creazione di un metodo settime
	 * che accetta questi input lista di argomenti cioè una serie di espressioni
	 * (variabili) che servono per fornire i PARAMETRI formali
	 */

	public void setTime(int h, int mn, int s, int ms) {

		if (h < 24 && h >= 0) {
			this.hours = h;
		} else {
			this.hours = 0;
		}
		if (h < 60 && h >= 0) {
			this.minutes = mn;
		} else {
			this.minutes = 0;
		}
		if (h < 24 && h >= 0) {
			this.seconds = s;
		} else {
			this.seconds = 0;

		}
		if (ms < 1000 && ms >= 0) {
			this.milliseconds = ms;
		} else {
			milliseconds = 0;
		}
	}

	// creazione di un metodo gettime per la restituzione dei valori
	public String getTime() {
		return hours + ":" + minutes + ":" + seconds + ": " + milliseconds;

	}

//creazione di un constructore che inizialisa i variabili a 0

	public Time() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);

		it.esedra.corso.oussein.Time ousseinTime = new it.esedra.corso.oussein.Time();
		ousseinTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(ousseinTime.getTime());

		this.hours = this.minutes = this.seconds = this.milliseconds = 0;

	}

	// overload
	public static int dicrement(int i) {
		int c = 6; // scope della variabile a livello di metodo "locale"

		return c - i;
	}

	public static String dicrement(int i, String t, int z) {
		int n = 6;

		return t + ": " + n + i;
	}

	public static String dicrement(int i, int z, String t) {
		int n = 6;

		return n - i + " è = a " + t;
	}

	public static void main(String[] args) {

	}

}
