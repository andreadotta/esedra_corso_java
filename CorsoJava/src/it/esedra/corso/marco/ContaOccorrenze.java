package it.esedra.corso.marco;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ContaOccorrenze {

	public static void main(String[] args) {

		int contatoreParola = 0;
		// int carattere = 0;
		// int riga = 0;

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Inserire testo: ");
		String t = tastiera.nextLine();

		System.out.println("Inserire la parola di cui conteggiare le occorrenze: ");
		String w = tastiera.nextLine();

		StringTokenizer st = new StringTokenizer(t, ". , : ;");

		while (st.hasMoreTokens()) {
			t = st.nextToken();
			if (t.equals(w)) {
				contatoreParola++;
			}

		}

		System.out.println("Numero occorrenze: " + contatoreParola);

		tastiera.close();

	}

}
