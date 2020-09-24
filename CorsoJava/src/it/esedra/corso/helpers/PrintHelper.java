package it.esedra.corso.helpers;

import it.esedra.corso.libs.Time;

/**
 * Classe per effettuare il print di messaggi su console 
 * 
 * @author bauhausk
 *
 */
public class PrintHelper {

	/**
	 * Metodo che effettua il print su system out di un messaggio + di una stringa 
	 * e di data e ora in questa forma:
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - MESSAGGIO - STRINGA
	 * IL messaggio può essere NULL e quindi printa
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - STRINGA
	 * @param out
	 */
	public static void out(int out) {
		PrintHelper.out(out+"", null);
	}
	
	/**
	 * Metodo che effettua il print su system out di un messaggio + di una stringa 
	 * e di data e ora in questa forma:
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - MESSAGGIO - STRINGA
	 * IL messaggio può essere NULL e quindi printa
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - STRINGA
	 * @param out
	 */
	public static void out(String out) {
		PrintHelper.out(out, null);
	}
	
	/**
	 * Metodo che effettua il print su system out di un messaggio + di una stringa 
	 * e di data e ora in questa forma:
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - MESSAGGIO - STRINGA
	 * IL messaggio può essere NULL e quindi printa
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - STRINGA
	 * @param out
	 * @param msg
	 */

	public static void out(String out, String msg) {

		if (msg == null) {
			System.out.println("[" + Time.getCurrentTime() + "] " + "- " + out);

		} else {
			System.out.println("[" + Time.getCurrentTime() + "] " + "- " + msg + " - " + out);
		}

	}
}
