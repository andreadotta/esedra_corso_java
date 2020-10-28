package it.esedra.corso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snippet2408 {

	public Snippet2408() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		List<WhiteTerrier> wt = new ArrayList<>();
		List<Dog> dogs = new ArrayList<>();
		/**
		 * dogs = wt; //tipi incompatibili Una lista di WhiteTerrier è diversa da una
		 * lista di Dog.
		 * 
		 * dogs = wt; dogs.add(new WhiteTerrier()); dogs.add(new GoldenRetriever());
		 * 
		 */

		/**
		 * ANNOTAZIONI DI VARIANZA E WILDCARD
		 * 
		 * covarianza <? extends bound_type> Nota: l'annotazione di varianza <?> è uno
		 * shortcut equivalente a <? extends Object>
		 * 
		 * controvarianza <? super bound_type>
		 * 
		 * 
		 * Nota: ? non può essre uisate nella sezione dei paramentri di tipo o anche
		 * come indicatore di tipo (x esempio per dichiarare una variabile locale a un
		 * metodo o a una classe)
		 */

		// Dichiarazione Covariante
		List<? extends Number> numbers = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		// numbers = Arrays.asList(new Double[] {1.1, 1.3,1.4});
		Number number = numbers.get(0);

		// number.add(11.2); violazione type safety

		// Dichiarazione Controvariante
		List<? super Integer> other_numb = new ArrayList<Number>();
		other_numb.add(11);

		// Dichiarazione INVARIANTE
		// Siccome tutti i tipi generici sono invarianti il codice qui sotto non è
		// ammesso
		// List<Number> last_numb = new ArrayList<Integer>();

		/**
		 * Problema COVARIANZA DEGLI ARRAY
		 */
		Dog[] dogsArray = new WhiteTerrier[2];

		dogsArray[0] = new WhiteTerrier("Fido", 2);
		// genera una java.lang.ArrayStoreException:
		// dogsArray[1] = new GoldenRetriever("Fuffi", 3);

		// TIPO RAW
		// il tipo raw ovvero grezzo è un tipo generico cui manca l'indicazione
		// della lista degli argomenti di tipo
		List newDog = new ArrayList();
		newDog.add(new WhiteTerrier("Fido", 2));

		// non è possibile creare int_num come tipo Numbers<Integer>
		// Numbers<Integer>[] int_num = new Numbers<>[4];

		/*
		 * Restrizioni in: - utilizzo delle array - nei contesti static (vedi classe
		 * Numbers) - utilizzo delle variabili di tipo (vedi classi BiNumbers) -
		 * utilizzo di cast e instanceof - tipi primitivi: non è possibile utilizzare un
		 * tipo primitivo in una lista parametrizzata List<int> esem = - nelle eccezioni
		 * (la vedremo in seguito quando affronteremo le eccezioni) - nell'overloading
		 * non è possibile che due o più metodi differiscano dal tipo parametrizzato del
		 * tipo generico: ...void delete(List<Integer> list) { ...void
		 * delete(List<String> list) {
		 */

		// limitazione utilizzo di cast
//		Object list = new Object();
//		List<String> esem = (List<String>)list;
//		String data = esem.get(0);

		/**
		 * IDENTIFICATORE VAR
		 */
		// List<Boolean> bool_list = new ArrayList<Boolean>();
		var bool_list = new ArrayList<Boolean>();

		var string_list = new ArrayList<>();
		string_list.add("price");

	}
}
