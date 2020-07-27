package it.esedra.corso.gianni;

public class Sort {
	public static float[] sortArray(float[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[k]) {
					k = j;
				}
			}

			float temp = a[k];
			a[k] = a[i];
			a[i] = temp;
		}
		return a;
	}
}
