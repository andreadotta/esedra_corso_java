package it.esedra.corso.marco;

public class OrdineCrescente {

	public static double[] ordineCrescente(double[] elementi) {

		for (int i = 0; i < elementi.length - 1; i++) {
			int indiceConteggio = i;
			for (int j = i + 1; j < elementi.length; j++) {
				if (elementi[j] < elementi[indiceConteggio]) {
					indiceConteggio = j;
				}
			}

			double sottoinsOrd = elementi[indiceConteggio];
			elementi[indiceConteggio] = elementi[i];
			elementi[i] = sottoinsOrd;

		}

		return elementi;

	}

}
