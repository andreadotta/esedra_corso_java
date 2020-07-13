package it.esedra.corso;

public class Veicolo {

	private Volante volante;
	private Ruota[] ruote;
	private String colore;
	
	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Volante getVolante() {
		return volante;
	}

	public void setVolante(Volante volante) {
		this.volante = volante;
	}

	public Ruota[] getRuote() {
		return ruote;
	}

	public void setRuote(Ruota[] ruote) {
		this.ruote = ruote;
	}

	public Veicolo() {
		// TODO Auto-generated constructor stub
	}

}
