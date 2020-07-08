package it.esedra.corso.lynda;
public class Test {

	public static void main(String args[]) {
		int[] age = { 28, 32, 36, 40 };

		for (int x : age) {
			System.out.print(x);
			System.out.print(",");
		}
		System.out.print("\n");
		String[] names = { "Joke", "Layo", "Tola", "Busi" };
		for (String name : names) {
			System.out.print(name);
			System.out.print(",");
		}
		
	}
}