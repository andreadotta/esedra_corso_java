package it.esedra.corso.marco;

public class Individuo {

	private String eta;
	protected String nome;
	private String secondoNome;
	private String cognome;
	private String genere;
	private String codiceFiscale;
	
	public String getSecondoNome() {
		return secondoNome;
	}

	public void setSecondoNome(String secondoNome) {
		this.secondoNome = secondoNome;
	}

	public String getCodiceFiscale() {
		return "C.F.: " + codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getGenere() {
		return "Sesso: " + genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getEta() {
		return "Età: " + eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = "Nome e Cognome: " + nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
