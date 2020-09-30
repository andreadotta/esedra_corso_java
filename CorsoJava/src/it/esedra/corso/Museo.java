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

	/**
	 * OVERRIDE EQUALS
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Museo) {
			Museo museoObj = (Museo) obj;
			if (museoObj.getQuadri() == this.getQuadri() && museoObj.getStatue() == this.getStatue()) {
				return true;
			}

		} else {
			return false;
		}

		return false;
	}
}
