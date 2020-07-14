package it.esedra.corso.oussein.Chef;

import it.esedra.corso.helpers.PrintHelper;

public class Chef {
	
	private String nome;
	private String cognome;
	private String[] ricettePasta;
	private String nazione;
	private Coltelli coltelli;
	
	
	public final String getNazione() {
		return nazione;
	}

	protected void setNazione(String nazione) {
		
		this.nazione = nazione;
	}


	
	public Coltelli getColtelli() {
		return coltelli;
	}

	public void setColtelli(Coltelli coltelli) {
		this.coltelli = coltelli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String[] getRicettePasta() {
		return ricettePasta;
	}

	public void setRicettePasta(String[] ricettePasta) {
		this.ricettePasta = ricettePasta;
	}

	public void faChicken() {
		PrintHelper.out(" lo chef cucina chicken");
	}

	public void faSalad() {
		System.out.println("fa special salad");

	}

	public void faSandiwch() {
		System.out.println("fa dei buoni chandiwch");

	}

}
