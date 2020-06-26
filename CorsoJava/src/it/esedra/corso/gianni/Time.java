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
	private int milliseconds;
	
	/**
	 * questo metodo ritorna una stringa di ore minuti secondi e millisecondi.
	 * 
	 */
	
	public String getTime() {
		return this.hours + ":" + this.minutes + ":" + this.seconds + ":" + this.milliseconds;
	}
	
	/**
	 * questo metodo setta ore minuti secondi e millisecondi ai valori che gli vengono passati controllando che siano valori corretti. 
	 * 
	 */
	public void setTime(int h, int m, int s, int ms) {

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
		
		if (ms < 1000 && ms >= 0) {
			this.milliseconds = ms;
		} else {
			this.milliseconds = 0;
		}

	}
	
	/**
	 * questo costruttore setta ore minuti secondi e millisecondi a 0.
	 * 
	 */

	public Time() {
		this.hours = this.minutes = this.seconds = this.milliseconds = 0;
	}

	public static void main(String[] args) {

	}

}
