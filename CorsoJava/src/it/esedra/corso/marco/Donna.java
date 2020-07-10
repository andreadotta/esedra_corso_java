package it.esedra.corso.marco;

import it.esedra.corso.helpers.*;

public class Donna extends Persona {

	public final String genere = "Femminile";

	public Donna(String nome, String cognome, String dataDiNascita, int eta) {
		super(nome, cognome, dataDiNascita, eta);

	}

	public void print() {

		PrintHelper.out("Nome e Cognome: " + this.getNome() + " " + this.getCognome() + " - Genere: " + this.getGenere()
				+ " - Data di nascita: " + this.getDataDiNascita() + " - Età: " + this.getEta());
		PrintHelper.out("********************************************************");

	}

	@Override
	public String getGenere() {
		return genere;
	}

}
