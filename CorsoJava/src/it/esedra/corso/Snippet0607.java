package it.esedra.corso;

import it.esedra.corso.classiAstratte.Cane;

import it.esedra.corso.classiAstratte.Gatto;

public class Snippet0607 {

	public static void main(String[] args) {
		
		//keyword SUPER (vedi classi A e B)
		B b = new B(); // x in B; x in A = 10
					   //foo in A
		
		Cane cane = new Cane("bianco", "femmina");
		cane.faiVerso();

		Gatto gatto = new Gatto("rosso", "maschio");
		gatto.faiVerso();
		
		
		  
	}
}
