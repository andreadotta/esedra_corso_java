package it.esedra.corso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import it.esedra.corso.helpers.PrintHelper;

public class FirstClassValues {

	public static Function<Integer, Integer> mult(int value) {
		// catturiamo value e formiamo una closure
		return n -> value * n; // restituiamo la funzione
	}

	public static void main(String[] args) {
		// 1. assegnamo la funzione ad una variabile

		Function<Integer, Integer> add = x -> x + 1;

		int result = add.apply(10);// applichiamo la funzione
		PrintHelper.out(result);

		// 2. scorriamo gli elementi di una lista e al forEach passiamo come argomento
		// una funzione
		List<String> words = new ArrayList<>(Arrays.asList("Rosso", "Giallo", "Blu"));

		words.forEach(w -> {
			System.out.printf("%s", w);
		});

		// 3. ritorno di una funzione dalla applicazione di mult
		Function<Integer, Integer> mul10 = mult(10);
		result = mul10.apply(100);
		PrintHelper.out(result);

	}

}
