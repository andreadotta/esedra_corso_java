package it.esedra.corso;

public class Snippet0307 {

	/** PROGRAMMAZIONE ORIENTATA AGLI OGGETTI */
	
	/**
	 * EREDITARIETA 
	 * - permette ad una classe di avere come fossero i suoi i membri dati o le funzioni di  un'altra classe.
	 * - la classe DA cui si ereditano tali membri è detta SUPERCLASSE (o classe base)
	 * - la classe  che li eredita è detta CLASSE DERIVATA
	 * - si possono ereditare solo membri "public" o "protected" NON si possono ereditare i "private"
	 * - una classe può avere una sola superclasse.
	 * - ereditarietà multipla supporta solo dalle interfacce
	 * - (la classe MyTime è la classe derivata dalla superclasse Time)
	 */
	public static void main(String[] args) {
		MyTime time = new MyTime();
		time.setHours(18);
		time.setMinutes(50);	
		time.setSeconds(12);
		time.setMilliseconds(123);
		time.setDayName("Venerdì");
		System.out.println(time.getTimeExtended());
	}
	
	
	/**
	 * POLIMORFISMO
	 */
	
}
