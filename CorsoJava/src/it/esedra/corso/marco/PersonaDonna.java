package it.esedra.corso.marco;

public class PersonaDonna extends Persona {

	public PersonaDonna(String nome, String cognome, String dataDiNascita, int eta) {
		super(nome, cognome, dataDiNascita, eta);
		
	}
	
	public void print() {

		System.out.println("La persona è di genere femminile. I dati anagrafici sono:");
		System.out.println("Nome e Cognome: " + this.getNome() + " " + this.getCognome() + " - Data di nascita: " + this.getDataDiNascita() + " - Età: " + this.getEta());
		System.out.println("********************************************************");
		
	}

}
