package it.esedra.corso.oussein;

import it.esedra.corso.oussein.Canzone;
import it.esedra.corso.oussein.Song;

import it.esedra.corso.helpers.PrintHelper;

public class ChefTest {

	public ChefTest() {

	}

	public static void main(String[] args) {
		/**
		 * composizione primo devo istanzia le classi che la compongono
		 */

		//Titoli titoli = new Titoli();
	   // Artist artist = new Artist();
		//Lenght lenght = new Lenght();
		
		/**
		 * Istanzio un nuovo oggetto della classe canzone
		 */

	//Canzone canzone = new Canzone(titoli, artist, lenght);
		
		
		Chef normalchef = new Chef();
		normalchef.faChicken();
		ItalianChef italianchef = new ItalianChef();
		italianchef.faPasta();
		CineseChef cineschef = new CineseChef();
		cineschef.faFriedsRice();

		// instanceof permette di verificare a runtime seil il tipo di oggetto è
		// compatibile con il tipo indicato e nel caso restituisce un valore true
		if (italianchef instanceof Chef) {
			PrintHelper.out("fa un buona piatto di pasta");
		}

		if (cineschef instanceof Chef) {
			PrintHelper.out("fa dei chiken orange");
		}

	}
}