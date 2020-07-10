package it.esedra.corso.marco;

public abstract class Persona {

	private Nome nome;
	private Cognome cognome;
	private DataDiNascita dataDiNascita;
	private Eta eta;

	public Persona(Nome nome, Cognome cognome, DataDiNascita dataDiNascita, Eta eta) {

		}

	public Nome getNome() {
		return nome;
	}



	public void setNome(Nome nome) {
		this.nome = nome;
	}



	public Cognome getCognome() {
		return cognome;
	}



	public void setCognome(Cognome cognome) {
		this.cognome = cognome;
	}



	public DataDiNascita getDataDiNascita() {
		return dataDiNascita;
	}



	public void setDataDiNascita(DataDiNascita dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}



	public Eta getEta() {
		return eta;
	}



	public void setEta(Eta eta) {
		this.eta = eta;
	}

	public abstract String getGenere();
	
	private Persona() {
		
	}
	
	public abstract void print();

}
