package it.esedra.corso.gianni;

/**
 * Questa classe eredita da animale
 * 
 * @author gpaol
 *
 */
class Gatto extends Animale {
	
	/**
	 * questo metodo fa l'overloaad del metodo della classe base e stampa il colore. 
	 * 
	 * @author gpaol
	 *
	 */
	public void cheColore(String c, String c1) {
		System.out.printf(c, c1);
	}
}