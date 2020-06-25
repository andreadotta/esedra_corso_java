package it.esedra.corso.marco;

import java.util.Scanner;

public class ScambiaDueNumeri {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);

		int a, b;

		System.out.println("Inserire il primo numero: ");
		a = tastiera.nextInt();

		System.out.println("Inserire il secondo numero: ");
		b = tastiera.nextInt();

		if (a != b) {

			int i = 0;
			i = a;
			a = b;
			b = i;

		} else if (a == b) {

			System.out.println("I due numeri inseriti sono uguali - Scambio effettuato comunque.");

		}
		
		System.out.print("Ecco i numeri in ordine inverso: " + a + "-" + b);
		tastiera.close();

	}

}
