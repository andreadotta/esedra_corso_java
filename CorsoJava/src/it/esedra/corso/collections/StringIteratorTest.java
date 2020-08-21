package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;
import it.esedra.corso.helpers.PrintHelper;

public class StringIteratorTest {

	public StringIteratorTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Collection<String> StringCollection = new StringCollection();

		StringCollection.add((String) "Ciao");
		StringCollection.add((String) "Oggi");
		StringCollection.add((String) "Domani");

		
		Iterator<String> iterator = StringCollection.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");	
			PrintHelper.out(iterator.currentItem() + "");				
			PrintHelper.out(iterator.isDone() + "");				
		}



		
		

	}

}


