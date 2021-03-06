package it.esedra.corso;

import it.esedra.corso.libs.Time;

public class MyTime extends Time {

	/**
	 * Nome del giorno
	 */
	private String dayName;

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	/**
	 * Restituisco Time con aggiunto il nome del giorno
	 * 
	 * @return String restituisce i valori nome del giorno, hours, minutes, seconds,
	 *         milliseconds nella forma DAYNAME:HH:MM:SS:MS
	 */
	public String getTimeExtended() {
		return getDayName() + " " + this.getTime();
	}

	/**
	 * Questo metodo restituisce l'orario nel formato (HH:MM:SS).
	 * 
	 * @return String restituisce i valori hours, minutes, seconds nella forma
	 *         HH:MM:SS
	 */
	public String getTime() {

		return this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds();
	}

}
