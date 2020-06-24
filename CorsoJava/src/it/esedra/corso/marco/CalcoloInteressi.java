package it.esedra.corso.marco;

import java.util.Scanner;

public class CalcoloInteressi {

	public static void main(String[] args) {
		
		Scanner inputTastiera = new Scanner(System.in);
		
		double capitaleIniziale, capitaleFinale, tassoInteresse, interesse, numeroAnni;
		
		System.out.println("Inserire il capitale iniziale: ");
		capitaleIniziale = inputTastiera.nextDouble();
		
		System.out.println("Inserire il tasso di interesse da applicare: ");
		tassoInteresse = inputTastiera.nextDouble();
		
		System.out.println("Inserire il numero di anni su cui devono essere calcolati gli interessi: ");
		numeroAnni = inputTastiera.nextDouble();
		
		interesse = capitaleIniziale * (tassoInteresse / 100) * numeroAnni;
		capitaleFinale = (capitaleIniziale + interesse);
		
		System.out.println("Il capitale dopo " + (int)numeroAnni + " anno(i) è: " + capitaleFinale);
		inputTastiera.close();
				
	}

}
