package it.esedra.corso.gianni;

/*
 *  Questa classe estende quadrilatero, calcola l'area e il permietro di un rettangolo.
 *  
 */
public class Rettangolo extends Quadrilatero {
	
	private float area = 0;
	private float perimetro = 0;
	
    private Rettangolo() {
		
	}

	public Rettangolo(float b, float h) {
		super.setBase(b);
		super.setAltezza(h);
	}

	public float calcolaArea() {
		area = super.getBase() * super.getAltezza();
		System.out.println(area);
		return area;
	}

	public float calcolaPerimetro() {
		perimetro = (super.getBase() + super.getAltezza()) * 2;
		System.out.println(perimetro);
		return perimetro;
	}
}
