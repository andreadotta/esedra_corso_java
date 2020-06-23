package it.esedra.corso.marco;

public class Frazioni {
	
	/*
	 * Voglio creare una classe apposita che contenga i metodi per ricevere due frazioni, inserendo
	 * numeratore (numGen) e denominatore (denGen), e il metodo per farne la somma;
	 * inserisco anche un controllo sul caso in cui l'utente inserisca un denominatore nullo 
	 */

	// inizializzazione parametri della prima frazione
	int numGen = 0;
	int denGen = 1; 		// il den, per il programma, non deve essere == 0
	
	// creo un metodo costruttore per le frazioni, usando le variabili locali num e den
	public Frazioni(int num, int den) {
		
		numGen = num;
		denGen = den;
		
		// prevedo il caso in cui l'utente digiti lo zero in input per il denominatore
		if (den != 0) {
			denGen = den;
		}
		else
			denGen = 1;
	}
	
	// Creo un metodo di tipo String che visualizza le frazioni inserite dall'utente (ho scelto la notazione "num / den)
	public String Visualizzatore() {
		return numGen + "/" + denGen; 
			
	}
	
	// ora creo un metodo per sommare alla prima frazione una seconda (qui ho sudato parecchio per formalizzare il calcolo!)
	public Frazioni Somma(Frazioni f2) {
		return new Frazioni(numGen*f2.denGen + denGen*f2.numGen, denGen*f2.denGen);
	}
}
