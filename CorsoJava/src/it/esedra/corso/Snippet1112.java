package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

@Developer("Andrea")
public class Snippet1112 {

	/**
	 * 
	 * @param ex
	 */
	public static void executor(Executable ex) {
		ex.execute();
	}

	/**
	 * Esegue la somma di due numeri
	 * @param a indica il primo addendo
	 * @param b indica il secondo addendo
	 * @return restituisce un <code>int</code> che rappresenta la somam di a e b
	 * @throws Exception se a o b sono uguali a 0
	 * 
	 * @see java.lang.math
	 */
	@Developer("Max")
	public static int sum(int a, int b) throws Exception {
		PrintHelper.out("...");
		
		return a + b;
	}
	
	@Deprecated
	public void divide(){
		executor(() -> System.out.println("esecuzione"));
	}

}
