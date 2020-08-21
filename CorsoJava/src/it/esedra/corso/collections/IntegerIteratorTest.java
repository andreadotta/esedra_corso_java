package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;

public class IntegerIteratorTest {

	public static void main(String[] args) {

		Collection<Integer> IntegerCollection = new IntegerCollection();

		IntegerCollection.add((Integer) 16);
		IntegerCollection.add((Integer) 25);
		

		
		Iterator<Integer> iterator = IntegerCollection.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");	
			PrintHelper.out(iterator.currentItem() + "");
			
			PrintHelper.out(iterator.isDone() + "");	
	}

}
}
