package it.esedra.corso.lynda;

public class Time {
private int hours ;
private int minutes;
private int seconds;
private int milliseconds;
  
//An hour is represented by an integer from 0 to 23, (h < 24)
//A minute & seconds are represented by an integer from o to 59 (m,s <59)

public void setTime () {
	// ((int h, int mn, int s, int ms))
	this.hours= 0; 
	this.minutes=0;
	this.seconds=0;
	
	}
public void setTime(int h,int m, int s , int ms) {
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
	
	if (ms <1000 && ms >= 0) {
		}
	}
public String getTime() {
 return hours +":"+minutes + ":"+ seconds+":";
}
}
	
