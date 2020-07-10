package it.esedra.corso.gianni;

abstract public class Quadrilatero extends Poligono {
	final private int nLati = 4;
	final private int nAngoli = 4;
    public abstract float calcolaArea();
	
	public abstract float calcolaPerimetro();

	public int getNlati() {
		return nLati;
	}
	
	public int getNangoli() {
		return nAngoli;
	}
	

}
