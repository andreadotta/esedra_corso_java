package it.esedra.corso.gianni;

abstract public class Poligono {
	private float base;
	private float altezza;
	
	public abstract float calcolaArea();
	
	public abstract float calcolaPerimetro();
	
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltezza() {
		return altezza;
	}
	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}

	

}
