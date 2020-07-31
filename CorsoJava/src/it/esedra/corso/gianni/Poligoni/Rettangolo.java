package it.esedra.corso.gianni.Poligoni;

/*
 *  Questa classe estende quadrilatero, calcola l'area e il permietro di un rettangolo.
 *  
 */
public class Rettangolo extends Quadrilatero {
	
	public Rettangolo(Lato[] lati, Angolo[] angoli) {
		super(lati, angoli);

	}

	

	public void calcolaArea() {
		super.setArea( super.getBase() * super.getAltezza() );
	}

	public void calcolaPerimetro() {
		super.setPerimetro (  (super.getBase() + super.getAltezza()) * 2 );
	}

	
	
	@Override
	public void disegna(Shape s) {
		
	}
}
