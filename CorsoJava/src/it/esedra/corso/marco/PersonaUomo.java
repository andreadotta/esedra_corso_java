package it.esedra.corso.marco;

public class PersonaUomo extends Persona {

	public PersonaUomo(String nome, String cognome, String dataDiNascita, int eta) {
		super(nome, cognome, dataDiNascita, eta);

	}

	public void print() {

		System.out.println("La persona è di genere maschile. I dati anagrafici sono:");
		System.out.println("Nome e Cognome: " + this.getNome() + " " + this.getCognome() + " - Data di nascita: " + this.getDataDiNascita() + " - Età: " + this.getEta());
		System.out.println("********************************************************");
		
	}

}
