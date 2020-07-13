package it.esedra.corso;

public interface FunzioniVeicolo  {

	int LEFT = 1;
	int RIGHT = 2;
	boolean freccia(int direzione);
	void cambioDirezione(int direzione);
}
