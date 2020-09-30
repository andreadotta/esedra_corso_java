package it.esedra.corso;

public class Snippett1007 {

	public Snippett1007() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {
		Automobile formula1 = new Automobile();
		boolean frecciaSinistra = formula1.freccia(FunzioniVeicolo.LEFT);
		if (frecciaSinistra == false) {
			// visualizzare messaggio errore o una spia luminosa o sonara
		}
		formula1.freccia(FunzioniVeicolo.RIGHT);

		Camion iveco = new Camion();
		iveco.freccia(FunzioniVeicolo.LEFT);
		iveco.freccia(FunzioniVeicolo.RIGHT);

	}

}
