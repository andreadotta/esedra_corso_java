package it.esedra.corso.marco;

public class Anagrafica extends Individuo {
	
	private String indirizzo;
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getAnagrafica() {
		
		return getNome() + " " + getCognome() + " - " + getGenere() + " - " + getEta() + " - " + getIndirizzo();
		
	}	

}
