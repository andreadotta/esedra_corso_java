package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;

public class FloatCollentionTest {

	public FloatCollentionTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Collection<Float> floatCollention = new FloatCollection();

		floatCollention.add((float) 2.1);
		floatCollention.add((float) 2.2);
		floatCollention.add((float) 2.3);
		floatCollention.add((float) 2.4);
		floatCollention.add((float) 2.5);
		floatCollention.add((float) 2.6);
		floatCollention.add((float) 2.7);
		floatCollention.add((float) 2.8);
		floatCollention.add((float) 2.9);
		floatCollention.add((float) 3);
		floatCollention.add((float) 3.1);

		floatCollention.test();

	}

}
