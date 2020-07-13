package it.esedra.corso.marco;

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
	public void StampaDatiPersona() {
		
		PrintHelper.out("Dati Persona: " + this.getPersona());
		
	}

	@Override
	public void StampaDatiIndirizzo() {
		
		PrintHelper.out("Indirizzo: " + this.getIndirizzo());
		
	}

	
	
	
	
}
