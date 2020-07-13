package it.esedra.corso.marco.persona;

import it.esedra.corso.helpers.PrintHelper;

public class Anagrafica implements StampaPersona, StampaIndirizzo {

	private Persona persona;
	private Indirizzo indirizzo;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public void stampaDatiPersona() {
		
		PrintHelper.out("Dati Persona: " + this.getPersona());
		
	}

	@Override
	public void stampaDatiIndirizzo() {
		
		PrintHelper.out("Indirizzo: " + this.getIndirizzo());
		
	}

	
	
	
	
}
