package it.esedra.corso.oussein;

public class Time {
//dicheriazione dei variablili di classe
	private int hours;
	private int minutes;
	private int seconds;
	private int milliseconds;
	/*
	 *  Creazione di un metodo settime
	 * che accetta questi input lista di argomenti cioè una serie di espressioni
	 * (variabili) che servono per fornire i PARAMETRI formali
	 * @param int h hours
	 * @param int mn minutes
	 * @param int s seconds
	 * @param int ms milliseconds
	 */

	public void setTime(int h, int mn, int s, int ms) {

		if (h < 24 && h >= 0) {
			this.hours = h;
		} else {
			this.hours = 0;
		}
		if (mn < 60 && mn >= 0) {
			this.minutes = mn;
		} else {
			this.minutes = 0;
		}
		if (s < 60 && s >= 0) {
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

	/**
	 * Creazione di un metodo gettime per la restituzione dei valori
	 * @return String con i valori hours,minutes,seconds,milliseconds nella forma es. 15:11:12:07
	 
	 */
	public String getTime() {
		return hours + ":" + minutes + ":" + seconds + ":" + milliseconds;

	}

	/**
	 * Questo costruttore fornisce i valori dell'orario al momento dell'esecuzione
	 * del programma ( Date,calendar, Time)
	   
	 */

	public Time() {

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
