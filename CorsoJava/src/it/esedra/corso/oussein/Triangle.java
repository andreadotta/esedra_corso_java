package it.esedra.corso.oussein;

public class Triangle implements Forme {
	protected int base = 4;
	protected int altezza = 2;

	@Override
	public double aire() {

		return base * altezza * 0.5;
	}

}
