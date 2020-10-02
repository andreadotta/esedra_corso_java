package it.esedra.corso.gianni.Poligoni;

/*
 * 
 */
abstract public class Poligono implements Calcoli, Disegna {

	private float base;
	private float altezza;
	private Lato[] lato;
	private Angolo[] angolo;
	private Float area = Float.valueOf(0);
	private Float perimetro = Float.valueOf(0);

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Float getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(Float perimetro) {
		this.perimetro = perimetro;
	}

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
