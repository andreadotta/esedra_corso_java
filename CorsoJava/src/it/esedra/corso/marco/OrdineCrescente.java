package it.esedra.corso.marco;

import it.esedra.corso.helpers.PrintHelper;

public class OrdineCrescente {

	public static void main(String[] args) {

		double[] elementi = { 9.67, 3.41, 14.87, 7.13, 34.54, 21.88, 13.03 };

		for (int i = 0; i < elementi.length - 1; i++) {
			int indiceConteggio = i;
			for (int j = i + 1; j < elementi.length; j++)
				if (elementi[j] < elementi[indiceConteggio])
					indiceConteggio = j;

			double sottoinsOrd = elementi[indiceConteggio];
			elementi[indiceConteggio] = elementi[i];
			elementi[i] = sottoinsOrd;

			PrintHelper.out("Gli elementi dell'array in ordine crescente sono i seguenti : " + sottoinsOrd);

		}

	}

}
