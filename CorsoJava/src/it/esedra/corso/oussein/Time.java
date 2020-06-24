package it.esedra.corso.oussein;

public class Time {

	private int hours;
	private int minutes;
	private int seconds;

	public void setTime(int h, int mn, int s) {
		
		if (h < 24 && h >= 0) {
			this.hours = h;
		} else {
			this.hours = 0;
		}
		if (h < 60 && h >= 0) {
			this.minutes = mn;
		} else {
			this.minutes = 0;
		}
		if (h < 24 && h >= 0) {
			this.seconds = s;
		} else {
			this.seconds = 0;
			
		}

	}
	public String getTime() {
		return hours  + ":" + minutes + ":" + seconds;
		
	}

	public Time() {

		this.hours = this.minutes = this.seconds = 0;
		
	}

	public static void main(String[] args) {

	}

}
