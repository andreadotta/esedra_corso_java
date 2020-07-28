package it.esedra.corso.marco;

public class OrdineCrescenteTester {

	public static void main(String[] args) {

		double[] elementi = { 9.67, 3.41, 14.87, 7.13, 34.54, 21.88, 13.03 };
		double[] tester = OrdineCrescente.ordineCrescente(elementi);

		for (int i = 0; i < tester.length; i++) {
			System.out.println(tester[i]);
		}

	}

}
