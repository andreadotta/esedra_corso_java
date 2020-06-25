package it.esedra.corso.marco;

public class Time {

	private int hours;
	private int minutes;
	private int seconds;
	private int milliseconds;

	// questo metodo permette di impostare l'ora; vengono previsti i limiti numerici per le ore (0-24) e per minuti e secondi (0-60)
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

	// questo metodo inizializza tutte le variabili di classe a 0
	public Time() {

		this.hours = this.minutes = this.seconds = this.milliseconds = 0;

	}
	
	// questa classe permette di formattare l'ora in formato 'HH:MM:SS'
	public String getTime() {
		
		return hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
	}

}
