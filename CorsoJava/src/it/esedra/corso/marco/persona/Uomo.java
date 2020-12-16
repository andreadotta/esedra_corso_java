package it.esedra.corso.marco.persona;

public class Uomo extends Persona implements StampaPersona, StampaIndirizzo {

	public final String genere = "Maschile";
	public Object toString;

	public Uomo(String nome, String cognome, String dataDiNascita, int eta) {
		super(nome, cognome, dataDiNascita, eta);

	}

	@Override
	public String getGenere() {
		return genere;
	}

	@Override
	public void stampaDatiIndirizzo() {

	}

	@Override
	public void stampaDatiPersona() {

	}

}
