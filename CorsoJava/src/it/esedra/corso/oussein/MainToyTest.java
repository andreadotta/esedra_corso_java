package it.esedra.corso.oussein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.esedra.corso.collections.Collection;

public class MainToyTest {

	public static void main(String[] args) {
		//creare una liste di giocchi per nostro sito
		
		List<Toy> giocchi = new ArrayList<>();
		
		giocchi.add( new Toy("Topolino" ,  20   , "divertente" , 5));
		giocchi.add( new Toy("Nascondino" , 20  ,  "educativo" , 10));
		giocchi.add( new Toy("Palla prigioniera", 20  , "super intelligente" , 15));
		giocchi.add( new Toy("Piccolo  budha" , 120 , "sportivo" , 80));
		
		//selezionare la lista dei giocchini in ordine del prezzo 
		Collections.sort(giocchi, new PriceComparator());
		
		// print i caratteristiche di ogni giocchino
		
	for( Toy giocchino: giocchi) {
		System.out.println(giocchino.getName() +   "-"   + giocchino.getPrice()   +  "euros"   +   giocchino.getDesc()  +  ( "promo:"   +   giocchino.getPromo() + "§"));
		
	}
		
	}

}
