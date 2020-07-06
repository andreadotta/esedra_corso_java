package it.esedra.corso.gianni;

/**
 * Questa classe eredita da animale.
 * 
 * @author gpaol
 *
 */
class Cane extends Animale {

	public void Cane() {
		this.setVerso("bau");
	}

	/**
	 * Questo metodo sovrascrive il metodo della classe base e stampa il verso.
	 * 
	 * @author gpaol
	 *
	 */
	public void faiVerso() {
		System.out.println("il verso del cane è " + getVerso());
	}
}
