package it.esedra.corso.gianni.Poligoni;

/*
 * 
 * 
 */
public class Lato {
	private float lunghezza;

	public float getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(float lunghezza) {
		if (lunghezza >= 0) {
			this.lunghezza = lunghezza;
		}
	}

}
