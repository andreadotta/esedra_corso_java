package it.esedra.corso.marco;

import it.esedra.corso.marco.Persona;
import it.esedra.corso.helpers.PrintHelper;

public class PersonaExec {

	public static void main(String[] args) {

		/**
		 * Faccio la composizione dei parametri che compongono Persona, istanziando
		 * perciò le classi Nome, Cognome, DataDiNascita, Eta
		 */
		Nome nome = new Nome();
		Cognome cognome = new Cognome();
		DataDiNascita dataDiNascita = new DataDiNascita();
		Eta eta = new Eta();
		
		/**
		 * Istanzio un nuovo oggetto della classe Uomo
		 */
		Uomo uomo = new Uomo(nome, cognome, dataDiNascita, eta);
		/**
		 * Istanzio un nuovo oggetto della classe Donna
		 */
		Donna donna = new Donna(nome, cognome, dataDiNascita, eta);
		

	}

}
