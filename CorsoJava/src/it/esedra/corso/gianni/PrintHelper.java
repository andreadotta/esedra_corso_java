package it.esedra.corso.gianni;

import it.esedra.corso.libs.*;

public class PrintHelper {
	/**
	 * Metodo che effettua il print su system out di un messaggio + di una stringa e
	 * di data e ora in questa forma: [ORE:MINUTI:SECONDI:MILLISECONDI] - MESSAGGIO
	 * - STRINGA IL messaggio può essere NULL e quindi printa
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - STRINGA
	 * 
	 * @param msg
	 * @param out
	 */

	public static void out(String msg, String out) {

		if (msg == null) {
			System.out.println("[" + Time.getCurrentTime() + "] " + "- " + out);

		} else {
			System.out.println("[" + Time.getCurrentTime() + "] " + "- " + msg + " - " + out);
		}

	}

	/**
	 * Metodo che effettua il print su system out di un messaggio + di una stringa e
	 * di data e ora in questa forma: [ORE:MINUTI:SECONDI:MILLISECONDI] - MESSAGGIO
	 * - STRINGA IL messaggio può essere NULL e quindi printa
	 * [ORE:MINUTI:SECONDI:MILLISECONDI] - STRINGA
	 * 
	 * @param out
	 */

	public static void out(String out) {

		PrintHelper.out(null, out);

	}

}
