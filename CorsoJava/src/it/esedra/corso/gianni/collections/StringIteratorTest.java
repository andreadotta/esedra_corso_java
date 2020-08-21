package it.esedra.corso.gianni.collections;

import java.util.Arrays;
import it.esedra.corso.helpers.PrintHelper;
import it.esedra.corso.collections.Collection;
import it.esedra.corso.collections.FloatCollention;
import it.esedra.corso.collections.Iterator;

public class StringIteratorTest {

	public StringIteratorTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Collection<String> StringCollection = new StringCollection();

		StringCollection.add("Ciao");
		StringCollection.add("Oggi");
		StringCollection.add("Domani");

		
		Iterator<String> iterator = StringCollection.createIterator();

		while (iterator.hasNext()) {
			PrintHelper.out(iterator.next() + "");	
			PrintHelper.out(iterator.currentItem() + "");				
			PrintHelper.out(iterator.isDone() + "");				
		}



		
		

	}

}


