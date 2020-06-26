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
	 * Questo metodo ritorna una stringa di ore minuti secondi e millisecondi.
	 * 
	 * @return String orario in forma ore:minuti:secondi:millisecondi
	 */

	public String getTime() {
		return this.hours + ":" + this.minutes + ":" + this.seconds + ":" + this.milliseconds;
	}

	/**
	 * Questo metodo setta ore minuti secondi e millisecondi ai valori che gli
	 * vengono passati controllando che siano valori corretti.
	 * 
	 * @param h  ore
	 * @param m  minuti
	 * @param s  secondi
	 * @param ms millisecondi
	 */
	public void setTime(int h, int m, int s, int ms) {
		setHours(h);
		setMinutes(m);
		setSeconds(s);
		setMilliseconds(ms);
	}

	/**
	 * Questo costruttore setta ore minuti secondi e millisecondi a 0.
	 * 
	 */

	public Time() {
		this.hours = this.minutes = this.seconds = this.milliseconds = 0;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int h) {

		if (h < 24 && h >= 0) {
			this.hours = h;
		} else {
			this.hours = 0;
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int m) {
		if (m < 60 && m >= 0) {
			this.minutes = m;
		} else {
			this.minutes = 0;
		}
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int s) {
		if (s < 60 && s >= 0) {
			this.seconds = s;
		} else {
			this.seconds = 0;
		}
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int ms) {
		if (ms < 1000 && ms >= 0) {
			this.milliseconds = ms;
		} else {
			this.milliseconds = 0;
		}
	}

	public static void main(String[] args) {

	}

}
