package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Iterator;

public class StringIterator extends AbstractIterator<String> implements Iterator<String> {


	public StringIterator(String[] inputArray) {
		super(inputArray);
	}

	

}
