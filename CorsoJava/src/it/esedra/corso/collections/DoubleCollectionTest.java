package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;

public class DoubleCollectionTest {

	public DoubleCollectionTest() {
		
	}

	public static void main(String[] args) {
	Collection<Double> DoubleCollection = new DoubleCollection();
		
		DoubleCollection.add((Double) 2.1);
		DoubleCollection.add((Double) 2.2);
		DoubleCollection.add((Double) 2.3);
		DoubleCollection.add((Double) 2.4);
		DoubleCollection.add((Double) 2.5);
		DoubleCollection.add((Double) 2.6);
		DoubleCollection.add((Double) 2.7);
		DoubleCollection.add((Double) 2.8);
		DoubleCollection.add((Double) 2.9);
		DoubleCollection.add((Double) 3.0);
		
		
		DoubleCollection.test();

	}

}
