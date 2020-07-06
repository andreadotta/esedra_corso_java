package it.esedra.corso.marco;

import java.util.ArrayList;

public class PersonaClient {

	public static void main(String[] args) {

		ArrayList<Persona> entry = new ArrayList<Persona>();
		entry.add(new PersonaUomo("Giorgio", "Rossi", "21/06/1985", 35));
		entry.add(new PersonaDonna("Marta", "Bianchi", "01/04/1980", 40));
		entry.add(new PersonaUomo("Leonardo", "Verdi", "05/11/1990", 30));
		entry.add(new PersonaDonna("Agata", "Neri", "09/10/1950", 70));
		entry.add(new PersonaDonna("Maria", "Viola", "28/09/1960", 60));
		for (Persona p : entry) {
			p.print();

		}

	}

}
