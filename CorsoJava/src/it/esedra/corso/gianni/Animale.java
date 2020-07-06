package it.esedra.corso.gianni;

/**
 * Questa è una classe base.
 * 
 * @author gpaol
 *
 */
class Animale {
	private String colore;
	private String verso;

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getVerso() {
		return verso;
	}

	public void setVerso(String verso) {
		this.verso = verso;
	}

	/**
	 * Qesto metodo stampa il colore dell'animale.
	 * 
	 * @author gpaol
	 *
	 */
	public void cheColore() {
		System.out.println(colore);
	}

	/**
	 * Questo metodo stampa il verso dell'animale.
	 * 
	 * @author gpaol
	 *
	 */
	public void faiVerso() {
		System.out.println(verso);
	}
}