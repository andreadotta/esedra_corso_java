package it.esedra.corso.oussein.Forme;



public class ImplementTest {

	public static void main(String[] args) {
		Forme carre = new Carre();
		System.out.println(carre.aire());
		Forme triangle = new Triangle();
		System.out.println(triangle.aire());
		Forme cercle = new Cercle();
		System.out.println(cercle.aire());

	}

}
