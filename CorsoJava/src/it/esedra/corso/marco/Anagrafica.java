package it.esedra.corso.marco;

public class Anagrafica extends Individuo {

	public String indirizzo;
	public String cap;
	
	public String getCap() {
		return "CAP: " + cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	private String professione;

	public String getProfessione() {
		return "Professione: " + professione;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}

	public String getIndirizzo() {
		return "Indirizzo: " + indirizzo + ", " + getCap();
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getAnagrafica() {

		return getNome() + " " + getCognome() + " - " + getGenere() + " - " + getEta() + " - " + getCodiceFiscale();

	}
	
	/**
	 * Restituisce il nome con l'aggiunta del secondo nome (se previsto):
	 * @return String restituisce il nome e il secondo nome (se previsto) nella forma: getNome() + " " + getSecondoNome()
	 */
	public String getNomeExtended() {
		return this.getNome() + " " + getSecondoNome();
	}
	
	/**
	 * Restituisce i valori di getAnagrafica con getNomeExtended
	 * @return String restituisce l'anagrafica utilizzando getNomeExtended al posto di getNome
	 */
	public String getAnagraficaExtended() {

		return this.getNomeExtended() + " " + getCognome() + " - " + getGenere() + " - " + getEta() + " - " + getCodiceFiscale();

	}
	
	/**
	 * Override del metodo setNome
	 */
	public void setNome(String nome) {
		this.nome = "***" + nome + "***";
	}
		
}
