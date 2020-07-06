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
	
	private Gatto() {
		
	}
	
	public Gatto(String colore, String genere) {
		super.setColore(colore);
		super.setGenere(genere);
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