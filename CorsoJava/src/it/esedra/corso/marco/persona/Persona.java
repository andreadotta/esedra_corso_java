package it.esedra.corso.marco.persona;

public abstract class Persona {

	private String nome;
	private String cognome;
	private String dataDiNascita;
	private int eta;

	public Persona(String nome, String cognome, String dataDiNascita, int eta) {

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

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public abstract String getGenere();

	private Persona() {

	}

}
