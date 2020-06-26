package it.esedra.corso.marco;

import java.util.Calendar;
import java.util.Date;

/**
 * Questa classe crea le variabili di classe HOURS, MINUTES, SECONDS,
 * MILLISECONDS, e contiene i metodi per ricevere l'orario, e per visualizzarlo
 * nel formato (HH:MM:SS:MS).
 * 
 * @author marco
 *
 */

public class Time {

	private int hours; // ore
	private int minutes; // minuti
	private int seconds; // secondi
	private int milliseconds; // millisecondi

	/**
	 * Questo costruttore permette di impostare l'ora. Vengono previsti i limiti
	 * numerici per le ore (0-24), per minuti e secondi (0-60), e per i millisecondi
	 * (0-1000). Vengono forniti i seguenti parametri:
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
	 */
	public Time() {

		this.hours = this.minutes = this.seconds = this.milliseconds = 0;

	}

	/**
	 * Questo metodo restituisce l'orario nel formato (HH:MM:SS:MS).
	 * 
	 * @return String restituisce i valori hours, minutes, seconds, milliseconds
	 *         nella forma HH:MM:SS:MS
	 */
	public String getTime() {

		return hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
	}

}
