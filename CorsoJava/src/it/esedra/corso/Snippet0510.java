package it.esedra.corso;

import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class Snippet0510 {

	public Snippet0510() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		/**
		 * Dichiarazione di una lambda expression
		 * 
		 * lambda_parametro -> lambda_corpo
		 * 
		 * Per scrivere una lista di paramentri per una espressione lambda bisogna
		 * seguire le regole seguenti:
		 * 
		 * 
		 * 1. è possibile OMETTERE i tipi manifesti dei parametri solo se sono
		 * desumibili dal compilatore. 2. è possibile utilizzare il FINAL solo se i
		 * paramentri hanno tipi manifesto oppure VAR 3. possiamo utilizare le
		 * ANNOTAZIONI solo con TIPO MANIFESTO o VAR 4. se si usano + parametri e VAR,
		 * VAR deve essere usato per tutti o nessuno 5. non possiamo usare insieme
		 * paramentri con tipi manifesti insieme con paramentri con VAR 6. non possiamo
		 * usare insieme paramentri con tipi impliciti e insieme con paramentri con VAR
		 * 7. non possiamo usare insieme paramentri con tipi impliciti e con tipi
		 * manifesti 8. con un solo paramentro con tipo implicito possiamo omettere le
		 * parentesi che racchiudoni i parametri 9. è possiible usare una coppia di
		 * parentesi tonde vuote se non ci sono parametri 10. le parentesi tonde vanno
		 * usate in caso di 2 o + paramtri o nessun paramentro.
		 * 
		 * 
		 * OPERATORE LAMBDA ->
		 * 
		 * Il corpo della lambda può essere costituito da una espressione oppure da uno
		 * statement body {} Nel caso di una espressione la keyword return è
		 * sottointesa.
		 * 
		 * i -> i + 5; i tende a i + 5 (i goes to i + 5)
		 * 
		 * 
		 */

		// esempio di utilizzo del qualificatore FINAL con tipi manifesti oppure
		// se presente VAR
		IntConsumer function1 = (final int data) -> {
			int cons = data;
			cons *= 100;
		};

		// VAR usato per tutti i parametri formali
		// (String, String) -> String
		BiFunction<String, String, String> function2 = (var data1, var data2) -> data1.concat(data2);

		// non posso utilizzare var insieme ad un tipo implicito
		//BiFunction<String, String, String> function3 = (var data1, data2) -> data1.concat(data2).length();
		
		
		//ometto le parentesi tonde ho un solo parametro implicito
		ToIntFunction<Integer> function3  = z -> z+10;
		
		//non ho paramentri
		BooleanSupplier function4 = () -> true;
		
		//più paramentri tra tonde
		ToIntBiFunction<Integer, Integer> function5 = (x, y) -> x -y;
		
		
		Function<Double, Double> function6 = (Double v) ->
		{
			if (v > 10) {
				return v -10;
			} else {
				return v;
			}
			
		};
		
		/**
		 * Non CONFONDERE la sintassi del tipo funzione (Integer) -> int con la sintassi delle
		 * espèressioni lambda (Integer a) -> a.
		 */
		
		
	}
}
