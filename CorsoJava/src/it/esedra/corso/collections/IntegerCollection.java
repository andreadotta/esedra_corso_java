package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;

public class IntegerCollection extends AbstactCollections<Integer> implements Collection<Integer> {

	public IntegerCollection() {
		super(new Integer[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Integer> createIterator() {
		return new IntegerIterator(super.toArray());
	}

}
