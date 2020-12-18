package it.esedra.corso.marco.persona;

public class Indirizzo implements StampaIndirizzo {

	private String via;
	private String civico;
	private String CAP;
	private String citta;

	public Indirizzo(String via, String civico, String CAP, String citta) {

	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCAP() {
		return CAP;
	}

	public void setCAP(String cAP) {
		CAP = cAP;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public void stampaDatiIndirizzo() {

	}

}
