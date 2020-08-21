package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.gianni.PrintHelper;

public class FloatIteratorTest {

	public FloatIteratorTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Collection<Float> floatCollention = new FloatCollection();

		floatCollention.add((float) 2.1);
		floatCollention.add((float) 2.2);
		floatCollention.add((float) 2.3);

		
		Iterator<Float> iterator = floatCollention.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");	
			PrintHelper.out(iterator.currentItem() + "");				
			PrintHelper.out(iterator.isDone() + "");				
		}



		
		

	}

}
