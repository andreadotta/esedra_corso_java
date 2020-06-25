package it.esedra.corso.marco;

import java.util.Calendar;
import java.util.Date;

public class Time {

	// Vengono dichiarate le variabili di classe necessarie al programma
	private int hours;
	private int minutes;
	private int seconds;
	private int milliseconds;

	/*
	 *  questo costruttore permette di impostare l'ora; vengono previsti i limiti numerici per le ore (0-24), per minuti e secondi (0-60), e
	 *  per i millisecondi (0-1000) 
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

	// questo costruttore fornisce i valori dell'orario al momento dell'esecuzione del programma
	public Time() {

		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);				
		
		it.esedra.corso.marco.Time marcoTime = new it.esedra.corso.marco.Time();		
		marcoTime.setTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND));
		System.out.println(marcoTime.getTime()); 
                
	}
	
	// questa classe permette di formattare l'ora in formato 'HH:MM:SS:MS'
	public String getTime() {
		
		return hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
	}
	
	
}
