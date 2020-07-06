package it.esedra.corso.marco;

import java.util.ArrayList;

public class PersonaClient {

	public static void main(String[] args) {

		ArrayList<Persona> entry = new ArrayList<Persona>();
		entry.add(new Uomo("Giorgio", "Rossi", "21/06/1985", 35));
		entry.add(new Donna("Marta", "Bianchi", "01/04/1980", 40));
		entry.add(new Uomo("Leonardo", "Verdi", "05/11/1990", 30));
		entry.add(new Donna("Agata", "Neri", "09/10/1950", 70));
		entry.add(new Donna("Maria", "Viola", "28/09/1960", 60));
		for (Persona p : entry) {
			p.print();

		}

	}

}
