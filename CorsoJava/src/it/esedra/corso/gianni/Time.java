package it.esedra.corso.gianni;

/**
 * In questa classe dovete creare 3 variabili di classe (proprietà)
 * 
 * hours minutes seconds
 * 
 * 
 * Quindi create un costruttore che inizializzi queste variabili a 0.
 *
 */

public class Time {

	private int hours;
	private int minutes;
	private int seconds;
	
	public String getTime() {
		return this.hours + ":" + this.minutes + ":" + this.seconds;
	}
	
	public void setTime(int h, int m, int s) {

		if (h < 24 && h >= 0) {
			this.hours = h;
		} else {
			this.hours = 0;
		}

		if (m < 60 && m >= 0) {
			this.minutes = m;
		} else {
			this.minutes = 0;
		}

		if (s < 60 && s >= 0) {
			this.seconds = m;
		} else {
			this.seconds = 0;
		}

	}

	public Time() {
		this.hours = this.minutes = this.seconds = 0;
	}

	public static void main(String[] args) {

	}

}
