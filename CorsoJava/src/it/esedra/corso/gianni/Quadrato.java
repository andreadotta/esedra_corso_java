package it.esedra.corso.gianni;

public class Quadrato extends Poligono {
	private float area = 0;
	private float perimetro = 0;

	private Quadrato() {

	}

	public Quadrato(float b) {
		super.setBase(b);
	}

	public float calcolaArea() {
		area = super.getBase() * super.getBase();
		System.out.println(area);
		return area;
	}

	public float calcolaPerimetro() {
		perimetro = super.getBase() * 4;
		System.out.println(perimetro);
		return perimetro;
	}

}
