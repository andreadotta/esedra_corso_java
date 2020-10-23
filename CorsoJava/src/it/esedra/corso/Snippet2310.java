package it.esedra.corso;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import it.esedra.corso.helpers.PrintHelper;

public class Snippet2310 {

	public Snippet2310() {
		// TODO Auto-generated constructor stub
		
		/**
		 * GESTIONE ECCEZIONI IN JAVA REF:

		https://www.html.it/pag/15105/gestire-le-eccezioni/
		https://www.javaboss.it/eccezioni-checked-unchecked-java/
			
		 */
		
	}

	private static int divide(int a, int b) throws  MyArithmeticException {

		if (b == 0) {
			throw new MyArithmeticException("b deve essere diverso da zero");
		}
		return a/b;
	}
	
	private int instanceDivide(int a, int b) throws  MyArithmeticException  {
		return Snippet2310.divide(a, b);
	}
	
	public static void main(String[] args) {

		//Se non viene trovato nessun catch nello stack che possa gestire la
		//eccezione sollevata,, il programma viene interrotto.

		
		int result = 0;
		try {
			Snippet2310 sn = new Snippet2310();
			
			result = sn.instanceDivide(10, 0);
			PrintHelper.out(result);			
		} catch (MyArithmeticException e) {
			e.printStackTrace();
		} 
		result = 9;

	}

}

