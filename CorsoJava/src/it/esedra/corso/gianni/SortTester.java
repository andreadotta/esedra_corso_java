package it.esedra.corso.gianni;

public class SortTester {

	public static void main(String[] args) {
		float[] a = { 1, 8, 5, 6, 9, 15, 2 };
		float b[] = Sort.sortArray(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);

		}
	}
}
