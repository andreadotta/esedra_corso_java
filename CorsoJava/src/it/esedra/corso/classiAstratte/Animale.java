package it.esedra.corso.classiAstratte;

/**
 * Questa è una classe base.
 * 
 * @author gpaol
 *
 */
public abstract class Animale {

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	private String genere;
	private String colore;


	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public abstract String getVerso();


	/**
	 * Questo metodo stampa il verso dell'animale.
	 * 
	 * @author gpaol
	 *
	 */
	public abstract void faiVerso();

}