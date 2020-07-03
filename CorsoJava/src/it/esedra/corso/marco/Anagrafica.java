package it.esedra.corso.marco;

public class Anagrafica extends Individuo {
	
	public String eta = "37";
	public String nome = "Marco";
	public String cognome = "Simi";
	
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
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
	
	public String GetAnagrafica() {
		
		return getNome() + " " + getCognome() + " " + getEta();
		
	}	

}
