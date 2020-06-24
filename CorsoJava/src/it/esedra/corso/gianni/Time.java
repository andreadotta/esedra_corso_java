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

	public Time(int h, int m, int s) {
		this.hours = h;
		this.minutes = m;
		this.seconds = s;
	}
	
	public Time() {
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	

	public static void main(String[] args) {

	}

}
