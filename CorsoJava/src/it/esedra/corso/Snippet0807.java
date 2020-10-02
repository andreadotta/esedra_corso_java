package it.esedra.corso;

import it.esedra.corso.classiAstratte.Animale;
import it.esedra.corso.classiAstratte.Cane;
import it.esedra.corso.classiAstratte.Gatto;
import it.esedra.corso.classiAstratte.Testa;
import it.esedra.corso.classiAstratte.Tronco;
import it.esedra.corso.classiAstratte.Zampa;
import it.esedra.corso.helpers.PrintHelper;

public class Snippet0807 {

	public Snippet0807() {

	}

	public static void main(String[] args) {

		/**
		 * Nel caso di composizione primo devo istanzia le classi che la compongono
		 */
		Tronco tronco = new Tronco();
		Testa testa = new Testa();
		Zampa[] zampe = new Zampa[3];

		Cane cane = new Cane(testa, tronco, zampe);

		/**
		 * Istanzio direttamente la classe e poi gli elementi aggregati
		 * 
		 */
		Museo louvre = new Museo();
		Quadro[] quadri = new Quadro[3];
		Statua[] statue = new Statua[1];

		louvre.setQuadri(quadri);
		louvre.setStatue(statue);

		/**
		 * POLIMORFISMO
		 */
		Animale fuffi = new Cane(new Testa(), new Tronco(), new Zampa[3]);

		Cane romeo = new Cane(new Testa(), new Tronco(), new Zampa[3]);

		Gatto drago = new Gatto(new Testa(), new Tronco(), new Zampa[3]);

		fuffi = romeo; // assegno un nuovo riferimento a Cane è sempre possibile
						// assegnare un riferimento di una classe derivata a una classe base

		// instanceof permette di verificare a runtime seil il tipo di oggetto è
		// compatibile con il tipo indicato e nel caso restituisce un valore true

		if (romeo instanceof Animale) {
			PrintHelper.out("romeo è un animale");
		}

		if (fuffi instanceof Animale) {
			PrintHelper.out("drago è un animale");
		}

		if (fuffi instanceof Cane) {
			PrintHelper.out("drago è un cane");
		}

		romeo.faiVerso("bau bau");

		/**
		 * Ogni classe deriva dalla classe Object0
		 */

		PrintHelper.out(louvre.toString()); // to string è una rappresentazione testuale dell'istanza

		if (drago.equals(romeo)) {
			PrintHelper.out("drago è uguale a romeo");
		} else {
			PrintHelper.out("drago è diverso da romeo");
		}

		Museo uffizi = new Museo();

		uffizi.setQuadri(quadri);
		uffizi.setStatue(statue);

		if (uffizi.equals(louvre)) {
			PrintHelper.out("I musei sono uguali");
		} else {
			PrintHelper.out("I musei sono diversi");
		}

	}

}
