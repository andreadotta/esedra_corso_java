package it.esedra.corso.marco;

public class Corso {

	public static void main(String[] args) {
		/*
		 * Siamo nella Classe principale, dove posso richiamare i metodi della classe Frazioni per
		 * dichiarare le due frazioni da sommare e per stampare a schermo il risultato
		 */
		
		Frazioni f1 = new Frazioni(2, 3);
		Frazioni Somma = f1.Somma(new Frazioni(4, 6));
		
		System.out.println("La somma è: " + Somma.Visualizzatore());		
		
	}	

}
