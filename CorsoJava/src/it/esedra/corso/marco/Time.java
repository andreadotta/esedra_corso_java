package it.esedra.corso.marco;

import java.util.Calendar;
import java.util.Date;

public class Time {

	/*
	 * Vengono dichiarate le variabili di classe
	 */
	private int hours;
	private int minutes;
	private int seconds;
	private int milliseconds;

	/**
	 * Questo costruttore permette di impostare l'ora; vengono previsti i limiti
	 * numerici per le ore (0-24), per minuti e secondi (0-60), e Per i millisecondi
	 * (0-1000) Vengono forniti i seguenti parametri:
	 * 
	 * @param int h hours
	 * @param int m minutes
	 * @param int s seconds
	 * @param int ms milliseconds
	 */
	public void setTime(int h, int m, int s, int ms) {

		this.hours = h;
		this.minutes = m;
		this.seconds = s;
		this.milliseconds = ms;

		if (h < 24 && h >= 0) {
			this.hours = h;
		} else {
			hours = 0;
		}

		if (m < 60 && m >= 0) {
			this.minutes = m;
		} else {
			minutes = 0;
		}

		if (s < 60 && s >= 0) {
			this.seconds = s;
		} else {
			seconds = 0;
		}

		if (ms < 1000 && ms >= 0) {
			this.milliseconds = ms;
		} else {
			milliseconds = 0;
		}

	}

	/**
	 * Questo costruttore fornisce i valori dell'orario al momento dell'esecuzione
	 * del programma
	 * 
	 * @param Date     now
	 * @param Calendar cal
	 * @param Time     marcoTime
	 */
	public Time() {

		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);

		it.esedra.corso.marco.Time marcoTime = new it.esedra.corso.marco.Time();
		marcoTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND),
				cal.get(Calendar.MILLISECOND));
		System.out.println(marcoTime.getTime());

	}

	/**
	 * @return String restituisce i valori hours, minutes, seconds, milliseconds
	 *         nella forma HH:MM:SS:MS
	 */
	public String getTime() {

		return hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
	}

}
