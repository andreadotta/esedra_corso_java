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
	
	public Cane(Testa testa, Tronco tronco, Zampa[] zampe) {
		super(testa, tronco, zampe); //richiamo il costruttore della superclasse
		
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
