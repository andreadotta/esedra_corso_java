package it.esedra.corso.marco;

import java.util.Scanner;

public class OreInMinuti {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);

		double ora, minuti;

		System.out.print("Inserire il valore del tempo desiderato espresso in ORE (usare la virgola per le frazioni di ora): ");
		ora = tastiera.nextDouble();

		minuti = ora * 60;

		System.out.println("Il corrispondente valore in MINUTI è: " + (int)minuti);
			
		System.out.print("Adesso inserire il valore del tempo desiderato espresso in MINUTI: ");
		minuti = tastiera.nextDouble();
		
		ora = minuti / 60;
		
		System.out.println("Il corrispondente valore in ORE è: " + (int)ora);
		tastiera.close();

	}

}
