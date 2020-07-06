package it.esedra.corso.oussein;

import java.util.ArrayList;

public class EssereHumanTest {

	public static void main(String[] args) {
		ArrayList<EssereHuman> tab = new ArrayList<EssereHuman>();
		tab.add(new Uomo("Marco", "Vannini", 25));
		tab.add(new Donna("Lynda", "Grossi", 40));
		tab.add(new Uomo("Gianni", "Simi", 35));
		tab.add(new Donna("lidia", "Belli", 60));
		for (EssereHuman h : tab) {
			h.print();
		}
		
	}

}