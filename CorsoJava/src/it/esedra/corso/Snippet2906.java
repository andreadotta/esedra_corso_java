package it.esedra.corso;

import java.util.Calendar;
import java.util.Date;
import it.esedra.corso.libs.Time;
public class Snippet2906 {
	//MEMBRI COSTANTI
	//Un membro costante è un campo di sola lettura (readonly)
	//il suo valore non può essere modificato
	//può essere solo ottenuto, letto dopo che tale valore è stato assegnato.
	
	public static final int IVA = 22;
	
	
	public float calculatePrice(float price) {
		return price + (price*22)/100;
	}
	
	//membreo statico
	private static String msg;

	// Inizializzatore statico
	static {
		
		msg = "Current time is: ";
		
	}
	
	public static void main(String[] args) {
		
		
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		cal.setTime(now);
		//richiamo i metodi getter and setter
		Time time = new Time();
		time.setHours(cal.get(Calendar.HOUR_OF_DAY));
		time.setMinutes(cal.get(Calendar.MINUTE));

		
		//calcolo il prezzo comprensivo di IVA utilizzando un campod i sola lettura IVA
		Snippet2906 snippet = new Snippet2906();

		
		System.out.println(snippet.calculatePrice(20));
		
		//a quanto ammonta l'IVA
		System.out.println(Snippet2906.IVA);
		
		
		
	}
}
