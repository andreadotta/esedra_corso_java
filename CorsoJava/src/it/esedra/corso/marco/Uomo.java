package it.esedra.corso.marco;

public class Uomo extends Persona {

	public final String genere = "Maschile";
	
	public Uomo(Nome nome, Cognome cognome, DataDiNascita dataDiNascita, Eta eta) {
		super(nome, cognome, dataDiNascita, eta);

	}

	public void print() {

		System.out.println("Nome e Cognome: " + this.getNome() + " " + this.getCognome() + " - Genere: " + this.getGenere() + " - Data di nascita: " + this.getDataDiNascita() + " - Età: " + this.getEta());
		System.out.println("********************************************************");
		
	}

	@Override
	public String getGenere() {
		return genere;
	}

}
