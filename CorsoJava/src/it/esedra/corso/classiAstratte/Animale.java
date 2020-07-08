package it.esedra.corso.classiAstratte;

/**
 * Questa è una classe base.
 * Questa classe è un esempio di composizione cioè di legame forte tra classi
 * @author gpaol
 *
 */
public abstract class Animale {

	private String genere;
	private String colore;
	private Testa testa;
	private Tronco tronco;
	private Zampa[] zampe;
	
	/**
	 * Costruttore esplicito con argomenti
	 * @param testa
	 * @param tronco
	 * @param zampe
	 */
	public Animale(Testa testa, Tronco tronco, Zampa[] zampe) {
		
	}
	
	public Testa getTesta() {
		return testa;
	}

	public void setTesta(Testa testa) {
		this.testa = testa;
	}

	public Tronco getTronco() {
		return tronco;
	}

	public void setTronco(Tronco tronco) {
		this.tronco = tronco;
	}

	public Zampa[] getZampe() {
		return zampe;
	}

	public void setZampe(Zampa[] zampe) {
		this.zampe = zampe;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public abstract String getVerso();


	/**
	 * Questo metodo stampa il verso dell'animale.
	 * 
	 * @author gpaol
	 *
	 */
	public abstract void faiVerso();

}