package it.esedra.corso;

import it.esedra.corso.helpers.PrintHelper;

public class Snippet2707 {

	public Snippet2707() {
		// TODO Auto-generated constructor stub
	}

	/** run **/
	public static void main(String[] args) {

		float[] arr = { 3, 35, 1, 76, 51, (float) 7.6, (float) 3.51 };
		Snippet2707.bubbleSort(arr);

		for (int i = 0; i < arr.length; i++) {
			PrintHelper.out(arr[i] + "");
		}

	}

	/**
	 * Algoritmo didattico di ordinamento
	 */
	public static void bubbleSort(float[] a) {
		int n = a.length;
		float temp = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 1; j < (n - i); j++) {

				if (a[j - 1] > a[j]) {
					// swap dell'elemento
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}

		}

	}

}
