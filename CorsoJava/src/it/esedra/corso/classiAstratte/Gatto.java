package it.esedra.corso.classiAstratte;

import it.esedra.corso.helpers.PrintHelper;

/**
 * Questa classe eredita da animale
 * 
 * @author gpaol
 *
 */
public class Gatto extends Animale {

	private final String verso = "miao";
	

	public Gatto(Testa testa, Tronco tronco, Zampa[] zampe) {
		super(testa, tronco, zampe); //richiamo il costruttore della superclasse
		
	}
	

	
	@Override
	public void faiVerso() {
		PrintHelper.out(getVerso(), "gatto");
	}

	@Override
	public String getVerso() {
		return verso;
	}


}