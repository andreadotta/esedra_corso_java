package it.esedra.corso.classiAstratte;

/**
 * FINAL rappresenta una eccezione alla ereditarietà
 */
public final class Barboncino extends Cane {

	
	
	public Barboncino(Testa testa, Tronco tronco, Zampa[] zampe) {
		super(testa, tronco, zampe); //richiamo il costruttore della superclasse
		
	}

}
