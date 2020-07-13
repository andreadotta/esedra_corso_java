package it.esedra.corso.gianni;

public class Corso {
	public static void main(String[] args) {
		Poligono rettangolo = new Rettangolo(5, 10);

		Poligono quadrato = new Quadrato(2);

		rettangolo.calcolaArea();
		rettangolo.calcolaPerimetro();

		quadrato.calcolaArea();
		quadrato.calcolaPerimetro();

		System.out.println(quadrato instanceof Poligono);
	}

}
