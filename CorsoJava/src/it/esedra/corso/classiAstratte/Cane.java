package it.esedra.corso.classiAstratte;

import it.esedra.corso.helpers.PrintHelper;

/**
 * Questa classe eredita da animale.
 * 
 * @author gpaol
 *
 */
public class Cane extends Animale {

	private final String verso = "bau";
	
	private Cane() {
		
	}
	public Cane(String colore, String genere) {
		super.setColore(colore);
		super.setGenere(genere);
	}
	
	/**
	 * Questo metodo sovrascrive il metodo della classe base e stampa il verso.
	 * 
	 * @author gpaol
	 *
	 */
	public void faiVerso() {
		PrintHelper.out(getVerso(), "cane");
	}

	@Override
	public String getVerso() {
		return verso;
	}


	

}
