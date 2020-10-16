package it.esedra.corso;

import java.util.HashSet;
import java.util.Set;
import java.util.function.DoubleSupplier;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;

import it.esedra.corso.helpers.PrintHelper;

public class Snippet1610 {

	class MyInteger {
		public int sum(int a, int b) { return a +b + a;}
	}
	class Math //
	{
		public String toString() { return "[Math]"; }
	}
	public Snippet1610() {
		// TODO Auto-generated constructor stub
		/**
		 * SINTASSI HANDLE
		 * 
		 * Riferimento a un metodo statico
		 * 
		 * type_name::static_metod_name
		 * 
		 * Riferimento ad un metodo d'istanza di un oggetto
		 * 
		 * istance_reference::instance_method_name
		 * 
		 * Per utilizzare un riferimento ad un metodo dobbiamo scrivere
		 * il nome della classe (o dell'istanza) il separatore :: e il 
		 * nome del metodo
		 * 
		 * 
		 * 
		 */
		
		IntBinaryOperator bo = (left, right) -> left + right;
		
		PrintHelper.out("Ris bo: " + bo.applyAsInt(10, 10));

		MyInteger mi = new MyInteger();
		IntBinaryOperator bo_1 = mi::sum; 
		
		PrintHelper.out("Ris bo_1: " + bo_1.applyAsInt(10, 10));
		
		/**
		 * Così come effettuo rifimenti ai metodi
		 * posso effettuare ai costruttori
		 * 
		 * Sintassi
		 * type_name::new
		 * 
		 * 
		 * THIS e SUPER
		 * this::method_name
		 * super::method_name
		 * 
		 * 
		 */
		
		
		//TARGET TYPING
		/**
		 * Il target typing è il tipo di destinazione
		 * Deve essere compatibile con il tipo inferito o dedotto dal compilatore.
		 * 
		 * Abbiamo due tipi di espressione
		 * 1. standalone: il tipo è determinabile
		 * 2. poly: il tipo è dipendente dal contesto dell'espressione
		 * 
		 * 
		 * contesti valutativi di poly expression:
		 * 1. assegnazione
		 * 2. invocazione
		 * 3. conversione esplictita (casting context)
		 * 
		 */
		
		String name = "Roberto";
		
		
		//poly
		Set<String> sss = new HashSet<>();
		Set<Double> zzz = new HashSet<>();
		
		IntSupplier is = () -> 10;
		DoubleSupplier ds = () -> 10;
		
		
		//IL PACKAGE JAVA.UTIL.FUNCTION
		//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
		
		
		
		
	}
	
	public static void main(String[] args) {
		Operations op = new Operations();
		op.get(1, 10);
		op.set(1000, 2000);
		Snippet1610 sn1 = new Snippet1610();
		
	
		
	}		
	
	
}


