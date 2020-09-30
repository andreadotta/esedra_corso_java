package it.esedra.corso.marco.persona;

import it.esedra.corso.helpers.*;
import it.esedra.corso.marco.persona.Persona;

public class PersonaExec {

	public static void main(String[] args) {

		Uomo u1 = new Uomo("Marco", "Simi", "29/09/82", 37);
		Indirizzo indirizzoU1 = new Indirizzo("Via del Tufo", "1", "58100", "Grosseto");

		if (u1 instanceof Persona) {
			PrintHelper.out("'u1' è una persona");
		} else {
			PrintHelper.out("'u1' è un bot!");
		}

		Anagrafica p1 = new Anagrafica();
		p1.setPersona(u1);
		p1.setIndirizzo(indirizzoU1);
		p1.stampaDatiPersona();
		p1.stampaDatiIndirizzo();

	}

}
