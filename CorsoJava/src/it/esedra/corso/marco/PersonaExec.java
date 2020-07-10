package it.esedra.corso.marco;

import it.esedra.corso.marco.Persona;
import it.esedra.corso.helpers.PrintHelper;

public class PersonaExec {

	public static void main(String[] args) {

		/**
		 * Faccio la composizione dei parametri che compongono Persona, istanziando
		 * perciò le classi Nome, Cognome, DataDiNascita, Eta
		 */
		Nome name = new Nome();
		Cognome surname = new Cognome();
		DataDiNascita dateOfBirth = new DataDiNascita();
		Eta age = new Eta();
		
		/**
		 * Istanzio un nuovo oggetto della classe Uomo
		 */
		Uomo uomo = new Uomo(name, surname, dateOfBirth, age);
		/**
		 * Istanzio un nuovo oggetto della classe Donna
		 */
		Donna donna = new Donna(name, surname, dateOfBirth, age);
		
		uomo.print();
		donna.print();
		
		/**
		 * Overload
		 */
		
		Uomo marco = new Uomo(new Nome(), new Cognome(), new DataDiNascita(), new Eta());
		Donna francesca = new Donna(new Nome(), new Cognome(), new DataDiNascita(), new Eta());
		
		marco.print();
		francesca.print();
	
	}

}
