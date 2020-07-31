package it.esedra.corso.gianni.Poligoni;

/*
 * 
 * 
 */
public class Angolo {
	private float ampiezza;

	public float getAmpiezza() {
		return ampiezza;
	}

	public void setAmpiezza(float ampiezza) {
		if (ampiezza >= 0 && ampiezza <= 359) {
			this.ampiezza = ampiezza;
		}
	}

}
