package it.esedra.corso.gianni;

/* 
 * Questa classe estende quadrilatero, calcola l'area e il permietro di un quadrato.
 * 
 */
public final class Quadrato extends Quadrilatero {

	public Quadrato(Lato[] lati, Angolo[] angoli) {
		super(lati, angoli);

	}


	public void calcolaArea() {
		super.setArea( super.getBase() * super.getBase() );
	}

	public void calcolaPerimetro() {
			
	}


	@Override
	public void disegna(Shape s) {
		// TODO Auto-generated method stub
		
	}


}
