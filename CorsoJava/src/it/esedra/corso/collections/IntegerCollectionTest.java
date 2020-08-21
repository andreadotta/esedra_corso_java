package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;

public class IntegerCollectionTest {

	public static void main(String[] args) {

		Collection<Integer> integerCollection = new IntegerCollection();

		integerCollection.add((int) 2);
		integerCollection.add((int) 4);
		integerCollection.add((int) 16);
		integerCollection.add((int) 24);
		integerCollection.add((int) 14);

		integerCollection.test();

	}

}
