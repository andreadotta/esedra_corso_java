package it.esedra.corso.gianni;

public class Corso {
	public static void main(String[] args) {

		Poligono rettangolo = null;//new Rettangolo(5, 10);

		rettangolo.calcolaArea();
		rettangolo.calcolaPerimetro();

		PrintHelper.out("Area del rettangolo", rettangolo.getArea().toString());
		PrintHelper.out("Perimentro del rettangolo", rettangolo.getPerimetro().toString());


	}

}
