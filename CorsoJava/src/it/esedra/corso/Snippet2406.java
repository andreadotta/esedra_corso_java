package it.esedra.corso;

public class Snippet2406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int  x = 1;
		//questo metodo restitusice il valore di x incrementato di 1
		
		/*
		 * per richiamare un metodo dobbiamo scrivere:
		 * 1. l'indentificatore nome della classe
		 * 2. l'operatore di accesso . "il punto"
		 * 3. l'indentificatore del metodo da richiamare, cioè il suo nome
		 * 4. l'opratore di invocazione () la coppia di parentesi tonde
		 * 5. la lista di argomenti cioè una serie di espressioni (variabili, costanti, espressioni complesse
		 * 	  che servono per fornire i PARAMETRI formali o argomenti, che sono opzionali
		 */

		int y = Snippet2406.increment(x);
		String str0 = Snippet2406.increment(x, " i valori",  3);
		String str1 = Snippet2406.increment(x, 2, " la stringa");
		System.out.println(y);
		System.out.println(str0);
		System.out.println(str1);
	}
 
	/**
	 * OVERLOAD
	 * Le informazioni che rappresentano la segnatura del metodo sono:
	 * 1. nome del metodo
	 * 2. numero, tipo, ordine dei parametri 
	 * 3. NON (mai) il valore restituito
	 * @param i
	 * @return
	 */
	public static int increment(int i) {
		int n = 3; //scope della variabile a livello di metodo "locale"

		return n + i;
	}
	
	public static String increment(int i, String h, int z) {
		int n = 3;

		return h + ": " + n + i;
	}
	
	public static String increment(int i, int z, String h) {
		int n = 3;

		return n + i+ " è = a " + h;
	}
	

	

}

