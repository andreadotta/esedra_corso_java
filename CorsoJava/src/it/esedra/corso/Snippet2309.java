package it.esedra.corso;

import java.util.ArrayList;
import java.util.List;

import it.esedra.corso.helpers.PrintHelper;

class S {
	public int a = 1;
}

public class Snippet2309 {

	public static void main(String[] args) {
		// Shallow copy
		List<S> s1 = new ArrayList<>();
		s1.add(new S());

		List<S> s2 = new ArrayList<>(s1);

		s2.get(0).a = 3; // se modifico il campo a di s2 si ripercuote anche su s1

		PrintHelper.out("s1.a: " + s1.get(0).a + " s2.a: " + s2.get(0).a);

		// deep copy

		List<S> s3 = new ArrayList<>();
		s3.add(new S());

		List<S> s4 = new ArrayList<>();

		for (S element : s3) {
			S copy = new S();
			copy.a = element.a;
			s4.add(copy);
		}

		s3.get(0).a = 3; // se modifico il campo a di s2 si ripercuote anche su s1

		PrintHelper.out("s3.a: " + s3.get(0).a + " s4.a: " + s4.get(0).a);

	}

}
