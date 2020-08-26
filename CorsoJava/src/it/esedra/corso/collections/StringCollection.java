package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;

public class StringCollection extends AbstactCollections<String> implements Collection<String> {

	public StringCollection() {
		super(new String[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<String> createIterator() {
		return new StringIterator(super.toArray());
	}

}
