package it.esedra.corso.marco;

import it.esedra.corso.helpers.*;

public class Donna extends Persona {

	public final String genere = "Femminile";

	public Donna(String nome, String cognome, String dataDiNascita, int eta) {
		super(nome, cognome, dataDiNascita, eta);

	}

	
	@Override
	public String getGenere() {
		return genere;
	}

}
