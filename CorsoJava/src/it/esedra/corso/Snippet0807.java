package it.esedra.corso;

import it.esedra.corso.classiAstratte.Cane;
import it.esedra.corso.classiAstratte.Testa;
import it.esedra.corso.classiAstratte.Tronco;
import it.esedra.corso.classiAstratte.Zampa;

public class Snippet0807 {

	public Snippet0807() {

	}

	public static void main(String[] args) {

		/**
		 * Nel caso di composizione
		 * primo devo istanzia le classi che la compongono 
		 */
		Tronco tronco = new Tronco();
		Testa testa = new Testa();
		Zampa[] zampe = new Zampa[3];
		
		Cane cane = new Cane(testa, tronco, zampe);
		
		/**
		 * Istanzio direttamente la classe e poi gli elementi aggregati
		 * 
		 */
		Museo museo = new Museo();
		Quadro[] quadri = new Quadro[3];
		Statua[] statue = new Statua[1];
		
		museo.setQuadri(quadri);
		museo.setStatue(statue);
		
		
	}

}
