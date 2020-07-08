/**
 * 
 */
package it.esedra.corso;

/**
 * Esempio di aggregazione cioè di legame debole tra classi
 */
public class Museo {
	
	private Quadro[] quadri;
	
	private Statua[] statue;

	/**
	 * Costrutture di default esplicito
	 */
	public Museo() {
		
	}

	public Quadro[] getQuadri() {
		return quadri;
	}

	public void setQuadri(Quadro[] quadri) {
		this.quadri = quadri;
	}

	public Statua[] getStatue() {
		return statue;
	}

	public void setStatue(Statua[] statue) {
		this.statue = statue;
	}

	
}
