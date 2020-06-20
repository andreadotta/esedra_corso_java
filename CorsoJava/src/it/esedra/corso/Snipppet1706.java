package it.esedra.corso;

public class Snipppet1706 {

	public static void main(String[] args) {
		Snipppet1706.operators();
		
		/**
		 * KEYWORD 
		 * if / else
		 * do
		 * for 
		 * beak
		 * switch
		 * continue
		 * return
		 * while
		 * throw
		 * assert
		 * synchronized
		 * try
		 */

		
		int a = 3;
		
		if (a > 10) 
			System.out.println("a > 10");
		else 
			if (a >= 5) 
				System.out.println("a > 5 e a < 10");
		else 
			if (a >= 0) 
			System.out.println("a >= 0 e a < 5");			
		
		//si evita l'errore di dangling else, cioè l'else che non è attribuito a nessun if
		
		if (a > 10) {
			System.out.println("a > 10");
		} else if (a >= 5) {
				System.out.println("a > 5 e a < 10");
		} else if (a >= 0) {
			System.out.println("a >= 0 e a < 5");			
		} 
		if (a > 10) {
			System.out.println("a > 10");
		} else if (a >= 5) {
				System.out.println("a > 5 e a < 10");
		} else if (a >= 0) {
			System.out.println("a >= 0 e a < 5");			
		} 
	
		/** switch case statement */
		int number = 4;
		
		switch (number) {
		case 1:
			System.out.println(" num = 1");
			break;
		case 2:
		case 3:
			System.out.println(" num = 2");
			break;
		case 4:
			System.out.println(" num = 4");
			break;
		default:
			break;
		}
		
		int d = 8;
		
		System.out.printf("a = [");
		do {
			System.out.printf("%d ", d--);
		} while(d >= 0);
		
		System.out.printf("]");		
		
		/** ciclo for infinito */
		for(;;) {
			break;
		}

		/** ciclo for migliorato da java 5 in avanti **/
		int[] arInteri = { 1, 200, 400, 500};
		for( int elem : arInteri) {
			System.out.println(elem);
		}
		
		
		for (int i = 0; i < arInteri.length; i++) {
			System.out.println(arInteri[i]);	
		}
		
	}
	public static void operators() {
		/* operatori unari + e -*/
		int  a = -55;
		int b = -a;
		
		System.out.println("b: " + b);
		
		int k = 100;
		int j = +100 - -k;

		System.out.println("j: " +j);
		
		
		/** operatori di incremento e decremento  POSTFISSO*/
		int res, c = 10, d = 9;
		
		res = c++ - d++;
		
		System.out.println("POSTFISSO res: " + res);
		
		/** operatori di incremento e decremento  PREFISSO*/
		
		int preRes, e = 10, f = 9;
		
		preRes = ++e - --f;
		
		System.out.println("PREFISSO preRes: " + preRes);
		
		/** Operatori uguaglianza */
		
		int g = 120, h = 111, i = 111, l = 112;
		
		boolean m = g < h != i > l;
		
		System.out.println("Uguaglianza m: " + m);
		
		/** Operatore logico condizionale 
		 * AND (&&) logico condizionale
		 * OR (||) logico condizionale
		 * NOT (!) logico o negazione logica
		 * 
		 * */
		
		int n = 1, o = 14;
		
		boolean p = n > 10 && o < 15;
	
		System.out.println("Risultato con operatore logico p: " + p);
		
		/** operatore NOT logico **/
		int q = 10;
		
		//il LINT è uno strumento che analizza il codice sorgente per contrassegnare errori
		// di programmazione
		boolean r = !(q > 10);
		
		System.out.println("Risultato con operatore NOT logico r: " + p);
		
		
	}
	
	
}
