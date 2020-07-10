package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class Camion implements FunzioniVeicolo, CicloVitaVeicolo, GestioneRimorchio {

	public Rimorchio rimorchio;

	public Rimorchio getRimorchio() {
		return rimorchio;
	}

	public void setRimorchio(Rimorchio rimorchio) {
		this.rimorchio = rimorchio;
	}

	public Camion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean freccia(int direzione) {
		if (direzione < 1 || direzione > 2 ) {
			return false;
		}
		PrintHelper.out("Camion Attivo le funzioni per giro a " + direzione);
		PrintHelper.out("Camion Accendo la lampadina");
		PrintHelper.out("Camion Accendo la lampadina posteriore");
		PrintHelper.out("Camion Chiudo la lampadina");		
		PrintHelper.out("Camion Chiudo la lampadina posteriore");			
		
		return true;
	}

	@Override
	public void cambioDirezione(int direzione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acquisto(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tagliandi(String[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rottamazione(String[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void curva() {
		// TODO Auto-generated method stub
		
	}

}
