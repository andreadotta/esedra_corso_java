package it.esedra.corso.collections;

import it.esedra.corso.collections.interfaces.Collection;
import it.esedra.corso.collections.interfaces.Iterator;

public class DoubleCollection extends AbstactCollections<Double> implements Collection<Double> {

	public DoubleCollection() {
		super(new Double[AbstactCollections.DEFAULT_SIZE]);
	}

	@Override
	public Iterator<Double> createIterator() {
		return new DoubleIterator(super.toArray());
	}

}
