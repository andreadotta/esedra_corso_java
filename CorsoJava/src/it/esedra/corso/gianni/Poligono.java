package it.esedra.corso.gianni;

abstract public class Poligono {

	private float base;
	private float altezza;
	private Lato lato;
	private Angolo angolo;

	public abstract float calcolaArea();

	public abstract float calcolaPerimetro();

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		if (base >= 0) {
			this.base = base;
		}
	}

	public float getAltezza() {
		return altezza;
	}

	public void setAltezza(float altezza) {
		if (altezza >= 0) {
			this.altezza = altezza;
		}
	}

}
