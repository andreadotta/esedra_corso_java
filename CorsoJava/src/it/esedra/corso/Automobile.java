package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class Automobile extends Veicolo implements FunzioniVeicolo, CicloVitaVeicolo {

	public Automobile() {
		super();
		Ruota[] ruote = new Ruota[3];
		super.setRuote(ruote);
		Volante volante = new Volante();
		super.setVolante(volante);
	}

	@Override
	public boolean freccia(int direzione) {
		// TODO Auto-generated method stub
		if (direzione < 1 || direzione > 2) {
			return false;
		}
		PrintHelper.out("Automobile Attivo le funzioni per giro a " + direzione);
		PrintHelper.out("Automobile Accendo la lampadina");
		PrintHelper.out("Automobile Chiudo la lampadina");
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

}
