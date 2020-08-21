package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;


public class DoubleIteratorTest {

	public DoubleIteratorTest() {
		
	}

	public static void main(String[] args) {
		
		Collection<Double> DoubleCollection = new DoubleCollection();

		DoubleCollection.add( 2.1);
		DoubleCollection.add( 2.2);
		DoubleCollection.add( 2.3);

		
		Iterator<Double> iterator = DoubleCollection.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");	
			PrintHelper.out(iterator.currentItem() + "");				
			PrintHelper.out(iterator.isDone() + "");				
		}

	

	}
	}
