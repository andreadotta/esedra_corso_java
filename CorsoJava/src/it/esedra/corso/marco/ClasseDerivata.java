package it.esedra.corso.marco;

import it.esedra.corso.libs.Time;

public class ClasseDerivata extends Time {
	
	private String year = "2020";
	private String dayName;

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Restituisco l'orario con l'aggiunta dell'anno corrente
	 * @return String restituisce i valori anno, nome del giorno, hours, minutes, seconds, milliseconds
	 *         nella forma YEAR:DAYNAME:HH:MM:SS:MS
	 */
	
	public String getTimeAndYear() {
		
		return getYear() + " " + getDayName() + " " + this.getTime();
	}
	
	/**
	 * Questo metodo restituisce l'orario nel formato (HH:MM).
	 * 
	 * @return String restituisce i valori hours, minutes
	 *         nella forma HH:MM
	 */
	
	public String getTime() {

		return this.getHours() + ":" + this.getMinutes();
		
	}

}
