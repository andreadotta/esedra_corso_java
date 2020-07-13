package it.esedra.corso.marco;

import it.esedra.corso.marco.Persona;
import it.esedra.corso.helpers.*;

public class PersonaExec {

	public static void main(String[] args) {

		Uomo u1 = new Uomo("Marco", "Simi", "29/09/82", 37);
		Donna d1 = new Donna("Francesca", "Rossi", "20/07/1994", 25);

		if (u1 instanceof Persona) {
			PrintHelper.out("'uomo' è una persona");
		} else {
			PrintHelper.out("'uomo' è un bot!");
		}

		if (d1 instanceof Persona) {
			PrintHelper.out("'donna' è una persona");
		} else {
			PrintHelper.out("'donna' è un bot!");
		}

	}

}
