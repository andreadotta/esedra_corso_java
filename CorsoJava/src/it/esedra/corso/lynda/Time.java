package it.esedra.corso.lynda;

/**
 * In questa classe dovete creare 3 variabili di classe (proprietà)
 * 
 * hours
 * minutes
 * seconds
 * 
 * 
 * Quindi create un costruttore  che inizializzi queste variabili a 0.
 * @author bauhausk
 *
 */
public class Time {
private int hours ;
private int minutes;
private int seconds;

public Time () {
	this.hours= 0;
	this.minutes=0;
	this.seconds=0;
	
}
public void setTime(int h,int m, int s) {
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
public String getTime() {
 return hours +":"+minutes + ":"+ seconds+":";
}
}
